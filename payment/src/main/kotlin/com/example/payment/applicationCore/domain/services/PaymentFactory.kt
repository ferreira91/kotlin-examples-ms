package com.example.payment.applicationCore.domain.services

import com.example.payment.applicationCore.domain.entities.Status
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.stereotype.Service

@Service
class PaymentFactory {
    fun createPayment(payment: Payment): Payment {
        payment.status = Status.PENDING
        return payment
    }

    fun confirmPayment(payment: Payment): Payment {
        payment.status = Status.CONFIRMED
        return payment
    }
}