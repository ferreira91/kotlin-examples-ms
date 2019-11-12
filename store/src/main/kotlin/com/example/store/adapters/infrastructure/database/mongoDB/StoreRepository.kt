package com.example.store.adapters.infrastructure.database.mongoDB

import com.example.store.applicationCore.domain.entities.Store
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository


@Repository
class StoreRepository(val template: MongoTemplate) {

    fun save(store: Store): Store = template.save(store)
    fun find(query: Query): List<Store> = template.find(query, Store::class.java)
    fun update(query: Query, update: Update): Store = template.findAndModify(query, update, FindAndModifyOptions().returnNew(true), Store::class.java)!!
    fun exists(query: Query): Boolean = template.exists(query, Store::class.java)
}
