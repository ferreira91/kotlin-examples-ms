package com.example.order.applicationCore.operations

import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.persistence.OrderPersistence

class GetByIdOrderOperation(val persistence: OrderPersistence) {
    fun execute(id: String): Order {
        return persistence.getById(id)
    }
}