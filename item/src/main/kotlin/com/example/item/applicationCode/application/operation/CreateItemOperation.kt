package com.example.item.applicationCode.application.operation

import com.example.item.applicationCode.domain.entities.Item
import com.example.item.applicationCode.persistence.ItemPersistence
import org.springframework.stereotype.Service

@Service
class CreateItemOperation(val persistence: ItemPersistence) {
    fun execute(item: Item): Item {
        return persistence.create(item)
    }
}