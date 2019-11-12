package com.example.order.applicationCore.domain.model

import org.springframework.data.annotation.Id
import java.time.LocalDate

data class Order(@Id val id: String?, val confirmationDate: LocalDate, val status: Status?, val total: Double, val itemsId: List<String>, val paymentId: String?)