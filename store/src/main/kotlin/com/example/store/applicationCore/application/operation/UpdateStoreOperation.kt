package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.domain.entities.Store
import com.example.store.applicationCore.persistence.StorePersistence
import org.springframework.stereotype.Service

@Service
class UpdateStoreOperation (val persistence: StorePersistence) {
    fun execute(id: String, store: Store): Store {
        return persistence.update(id, store)
    }
}