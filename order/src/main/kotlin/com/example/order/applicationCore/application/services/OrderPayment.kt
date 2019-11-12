package com.example.order.applicationCore.application.services

import com.example.order.adapters.infrastructure.clientRest.PaymentClient
import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.domain.entities.PaymentRequest
import org.springframework.stereotype.Service

@Service
class OrderPayment(val client: PaymentClient) {
    fun createPayment(order: Order) {
        val payment = PaymentRequest(order.id!!, order.total)
        val response = client.post(payment)
        if (!response.statusCode.is2xxSuccessful) "TODO handle error"
    }
}