package com.example.item.applicationCode.domain.model

import org.springframework.data.annotation.Id

data class Item(@Id val id: String?, val description: String, val unitPrice: Double, val quantity: Int, val storeId: String)