package com.example.payment.applicationCore.operations

import com.example.payment.applicationCore.domain.services.PaymentFactory
import com.example.payment.applicationCore.persistence.PaymentPersistence
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.stereotype.Service

@Service
class CreatePaymentOperation(val factory: PaymentFactory, val persistence: PaymentPersistence) {
    fun execute(payment: Payment): Payment {
        val paymentToCreate = factory.createPayment(payment)
        return persistence.create(paymentToCreate)
    }
}