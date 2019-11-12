package com.example.item.applicationCode.application.operation

import com.example.item.applicationCode.domain.entities.Item
import com.example.item.applicationCode.persistence.ItemPersistence
import org.springframework.stereotype.Service

@Service
class GetItemOperation(val persistence: ItemPersistence) {
    fun execute(storeId: String?): List<Item> {
        return persistence.get(storeId)
    }
}