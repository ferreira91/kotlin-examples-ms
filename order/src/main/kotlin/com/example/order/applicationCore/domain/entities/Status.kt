package com.example.order.applicationCore.domain.entities

enum class Status(val status: String) {
    CREATED("CREATED"),
    CLOSED("CLOSED"),
    CANCELED("CANCELED")
}