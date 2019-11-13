package com.example.payment.applicationCore.operations

import com.example.payment.applicationCore.domain.services.PaymentFactory
import com.example.payment.applicationCore.persistence.PaymentPersistence
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.stereotype.Service

@Service
class UpdatePaymentOperation(val factory: PaymentFactory, val persistence: PaymentPersistence) {
    fun execute(id: String, payment: Payment): Payment {
        val paymentToConfirm = factory.confirmPayment(payment)
        return persistence.update(id, paymentToConfirm)
    }
}