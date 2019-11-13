package com.example.payment.applicationCore.persistence

import com.example.payment.adapters.infrastructure.database.mongoDB.PaymentRepository
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PaymentPersistence(val repository: PaymentRepository) {
    fun create(payment: Payment): Payment = repository.save(payment)
    fun update(id: String, payment: Payment): Payment {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(id))

        val update = Update()
        update.set("status", payment.status!!)
        update.set("cardNumber", payment.cardNumber!!)
        update.set("paymentDate", LocalDate.now())

        return repository.update(query, update)
    }

    fun getById(id: String): Payment? = repository.findById(id)
}