package com.example.order.applicationCore.persistence

import com.example.order.adapters.infrastructure.database.mongoDB.OrderRepository
import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.domain.entities.Status
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class OrderPersistence(val repository: OrderRepository) {
    fun create(order: Order): Order = repository.save(order)
    fun getById(id: String): Order? = repository.findById(id)
    fun update(id: String, confirmationDate: LocalDate?): Order {

        var status = Status.CLOSED

        val query = Query()
        val update = Update()
        query.addCriteria(Criteria.where("id").`is`(id))
        if (confirmationDate == null) {
            status = Status.CANCELED
            query.addCriteria(Criteria.where("confirmationDate").lte(LocalDate.now().minusDays(10)))
            update.set("confirmationDate", LocalDate.now())
        } else {
            update.set("confirmationDate", confirmationDate)
        }
        update.set("status", status)

        return repository.update(query, update)
    }
}