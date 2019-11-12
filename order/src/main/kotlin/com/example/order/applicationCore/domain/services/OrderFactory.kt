package com.example.order.applicationCore.domain.services

import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.domain.entities.Status
import org.springframework.stereotype.Service

@Service
class OrderFactory {

    fun createOrder(order: Order): Order {
        order.status = Status.CREATED
        return order
    }
}