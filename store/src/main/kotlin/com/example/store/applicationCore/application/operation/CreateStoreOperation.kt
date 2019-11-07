package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.domain.model.Store
import com.example.store.applicationCore.persistence.StorePersistence
import org.springframework.stereotype.Service

@Service
class CreateStoreOperation(val persistence: StorePersistence) {
    fun execute(store: Store): Any {
        return persistence.save(store);
    }
}