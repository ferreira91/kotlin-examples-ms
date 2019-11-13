package com.example.payment.applicationCore.operations

import com.example.payment.applicationCore.application.services.PaymentOrder
import com.example.payment.applicationCore.domain.services.PaymentFactory
import com.example.payment.applicationCore.persistence.PaymentPersistence
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.stereotype.Service

@Service
class UpdatePaymentOperation(val factory: PaymentFactory, val persistence: PaymentPersistence, val paymentOrder: PaymentOrder) {
    fun execute(id: String, payment: Payment): Payment {
        val paymentToConfirm = factory.confirmPayment(payment)
        val paymentUpdated = persistence.update(id, paymentToConfirm)
        paymentOrder.updateOrder(id, paymentUpdated.orderId)
        return paymentUpdated
    }
}