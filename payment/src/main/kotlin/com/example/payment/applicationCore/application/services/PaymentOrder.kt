package com.example.payment.applicationCore.application.services

import com.example.payment.adapters.infrastructure.clientRest.OrderClient
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PaymentOrder(val client: OrderClient) {
    fun updateOrder(id: String, orderId: String) {
        client.update(id, orderId, LocalDate.now())
    }
}