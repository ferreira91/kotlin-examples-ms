package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.domain.model.Store
import org.springframework.stereotype.Service

@Service
class CreateStoreOperation {
    fun execute(store: Store): Any {
        return "execute create"
    }
}