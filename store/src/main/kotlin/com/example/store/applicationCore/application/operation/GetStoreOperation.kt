package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.domain.model.Store
import com.example.store.applicationCore.persistence.StorePersistence
import org.springframework.stereotype.Service

@Service
class GetStoreOperation(val persistence: StorePersistence) {
    fun execute(name: String?, address: String?): List<Store> {
        return persistence.get(name, address)
    }

    fun exist(id: String): Boolean = persistence.exist(id)
}