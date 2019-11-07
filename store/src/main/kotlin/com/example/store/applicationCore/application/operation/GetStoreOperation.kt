package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.persistence.StorePersistence
import org.springframework.stereotype.Service

@Service
class GetStoreOperation(val persistence: StorePersistence) {
    fun execute(name: String?, address: String?): Any {
        return persistence.get(name, address)
    }
}