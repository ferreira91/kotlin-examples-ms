package com.example.item.applicationCode.application.operation

import com.example.item.applicationCode.domain.entities.Item
import com.example.item.applicationCode.persistence.ItemPersistence
import org.springframework.stereotype.Service

@Service
class GetItemByIdOperation(val persistence: ItemPersistence) {
    fun execute(id: String): Item? {
        return persistence.getById(id)
    }
}