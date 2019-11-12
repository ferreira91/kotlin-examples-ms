package com.example.order.applicationCore.domain.model

enum class Status(val status: String) {
    OPEN("OPEN"),
    CLOSED("CLOSED"),
    CANCELED("CANCELED")
}