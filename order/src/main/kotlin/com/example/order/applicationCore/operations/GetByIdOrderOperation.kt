package com.example.order.applicationCore.operations

import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.persistence.OrderPersistence
import org.springframework.stereotype.Service

@Service
class GetByIdOrderOperation(val persistence: OrderPersistence) {
    fun execute(id: String): Order? {
        return persistence.getById(id)
    }
}