package com.example.order.adapters.infrastructure.database.mongoDB

import com.example.order.applicationCore.domain.entities.Order
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
class OrderRepository(val template: MongoTemplate) {
    fun save(order: Order): Order = template.save(order)
    fun findById(id: String): Order? = template.findById(id, Order::class.java)
    fun update(query: Query, update: Update): Order = template.findAndModify(query, update, FindAndModifyOptions().returnNew(true), Order::class.java)!!
}