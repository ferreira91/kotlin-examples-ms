package com.example.payment.applicationCore.operations

import com.example.payment.applicationCore.persistence.PaymentPersistence
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.stereotype.Service

@Service
class GetPaymentByIdOperation(val persistence: PaymentPersistence) {
    fun execute(id: String): Payment? {
        return persistence.getById(id)
    }
}