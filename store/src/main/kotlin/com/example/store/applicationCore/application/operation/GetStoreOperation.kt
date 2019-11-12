package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.domain.entities.Store
import com.example.store.applicationCore.persistence.StorePersistence
import org.springframework.stereotype.Service

@Service
class GetStoreOperation(val persistence: StorePersistence) {
    fun execute(name: String?, address: String?): List<Store> {
        return persistence.get(name, address)
    }

    fun exists(id: String): Boolean = persistence.exists(id)
}