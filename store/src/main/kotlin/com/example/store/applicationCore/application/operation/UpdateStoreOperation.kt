package com.example.store.applicationCore.application.operation

import com.example.store.applicationCore.domain.model.Store
import org.springframework.stereotype.Service

@Service
class UpdateStoreOperation {
    fun execute(id: String, store: Store): Any {
        return "execute update"
    }
}