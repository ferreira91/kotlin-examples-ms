package com.example.store.adapters.infrastructure.database.mongoDB

import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository


@Repository
class PaymentRepository(val template: MongoTemplate) {

    fun save(payment: Payment): Payment = template.save(payment)
    fun findById(id: String): Payment? = template.findById(id, Payment::class.java)
    fun update(query: Query, update: Update): Payment = template.findAndModify(query, update, FindAndModifyOptions().returnNew(true), Payment::class.java)!!
}
