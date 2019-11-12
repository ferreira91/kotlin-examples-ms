package com.example.order.applicationCore.operations

import com.example.order.applicationCore.application.services.OrderPayment
import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.domain.services.OrderFactory
import com.example.order.applicationCore.persistence.OrderPersistence
import org.springframework.stereotype.Service

@Service
class CreateOrderOperation(val factory: OrderFactory, val persistence: OrderPersistence, val orderPayment: OrderPayment) {
    fun execute(order: Order): Order {
        val orderToCreate = factory.createOrder(order)
        val orderCreated = persistence.create(orderToCreate)
        orderPayment.createPayment(orderCreated)
        return orderCreated
    }
}