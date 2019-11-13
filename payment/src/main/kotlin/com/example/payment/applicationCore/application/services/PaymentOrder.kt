package com.example.payment.applicationCore.application.services

import com.example.order.adapters.infrastructure.clientRest.OrderClient
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PaymentOrder(val client: OrderClient) {
    fun updateOrder(id: String) {
        client.update(id, LocalDate.now())
    }
}