package com.example.order.applicationCore.domain.entities

data class PaymentRequest(val orderId: String, val total: Double)