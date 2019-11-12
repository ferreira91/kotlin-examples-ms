package com.example.store.applicationCore.domain.entities

import org.springframework.data.annotation.Id

data class Store (@Id val id: String?, val name: String, val address: String)