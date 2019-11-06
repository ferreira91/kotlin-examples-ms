package com.example.store.applicationCore.application.operation

import org.springframework.stereotype.Service

@Service
class GetStoreOperation {
    fun execute(name: String, address: String): Any {
        return "execute get"
    }
}