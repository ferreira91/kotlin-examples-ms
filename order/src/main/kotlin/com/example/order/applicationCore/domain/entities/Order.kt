package com.example.order.applicationCore.domain.entities

import org.springframework.data.annotation.Id
import java.time.LocalDate

data class Order(@Id val id: String?, var confirmationDate: LocalDate?, var status: Status?, val total: Double, val items: List<Item>, val paymentId: String?)