package com.example.order.adapters.infrastructure.clientRest

import com.example.order.applicationCore.domain.entities.PaymentRequest
import com.example.order.applicationCore.domain.entities.PaymentResponse
import org.springframework.web.client.RestTemplate


class PaymentClient(private val template: RestTemplate) {

    companion object {
        const val PAYMENT_URL = "http://localhost:8080/api/payment/v1/payments"
    }

    fun post(payment: PaymentRequest) = template.postForEntity(PAYMENT_URL, payment, PaymentResponse::class.java)

}