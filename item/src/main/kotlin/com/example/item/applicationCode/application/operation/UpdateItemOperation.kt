package com.example.item.applicationCode.application.operation

import com.example.item.applicationCode.domain.entities.Item
import com.example.item.applicationCode.persistence.ItemPersistence
import org.springframework.stereotype.Service

@Service
class UpdateItemOperation(val persistence: ItemPersistence) {
    fun execute(id: String, item: Item): Any {
        return persistence.update(id, item)
    }
}