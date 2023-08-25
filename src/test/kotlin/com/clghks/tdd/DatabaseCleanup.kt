package com.clghks.tdd

import com.google.common.base.CaseFormat
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.Table
import jakarta.persistence.metamodel.EntityType
import jakarta.transaction.Transactional
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class DatabaseCleanup : InitializingBean {
    @PersistenceContext
    private val entityManager: EntityManager? = null
    private var tableNames: MutableList<String>? = null
    override fun afterPropertiesSet() {
        val entities = entityManager!!.metamodel.entities
        tableNames = entities.stream()
            .filter { e: EntityType<*> -> isEntity(e) && hasTableAnnotation(e) }
            .map { e: EntityType<*> ->
                val tableName = e.javaType.getAnnotation(Table::class.java).name
                tableName.ifBlank { CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.name) }
            }
            .collect(Collectors.toList())
        val entityNames = entities.stream()
            .filter { e: EntityType<*> -> isEntity(e) && !hasTableAnnotation(e) }
            .map { e: EntityType<*> -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.name) }
            .toList()
        tableNames?.addAll(entityNames)
    }

    private fun isEntity(e: EntityType<*>): Boolean {
        return null != e.javaType.getAnnotation(Entity::class.java)
    }

    private fun hasTableAnnotation(e: EntityType<*>): Boolean {
        return null != e.javaType.getAnnotation(Table::class.java)
    }

    @Transactional
    fun execute() {
        entityManager!!.flush()
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate()
        for (tableName in tableNames!!) {
            entityManager.createNativeQuery("TRUNCATE TABLE $tableName").executeUpdate()
            entityManager.createNativeQuery("ALTER TABLE $tableName ALTER COLUMN ID RESTART WITH 1").executeUpdate()
        }
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate()
    }
}