package com.example.store.applicationCore.domain.entities

import com.example.payment.applicationCore.domain.entities.Status
import org.springframework.data.annotation.Id
import java.time.LocalDate

data class Payment(@Id val id: String?, val total: Double, var status: Status?, val cardNumber: String?, val paymentDate: LocalDate?, val orderId: String)