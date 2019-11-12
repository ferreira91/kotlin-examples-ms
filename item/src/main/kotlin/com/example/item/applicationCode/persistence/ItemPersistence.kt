package com.example.item.applicationCode.persistence

import com.example.item.adapters.infrastructure.database.mongodb.ItemRepository
import com.example.item.applicationCode.domain.model.Item
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
class ItemPersistence(val repository: ItemRepository) {
    fun save(item: Item): Item {
        return repository.save(item)
    }

    fun getById(id: String): Item? {
        return repository.findById(id)
    }

    fun get(storeId: String?): List<Item> {
        val query = Query()
        if (!storeId.isNullOrEmpty()) query.addCriteria(Criteria.where("storeId").`is`(storeId))
        return repository.find(query)
    }


    fun update(id: String, item: Item): Item {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(id))

        val update = Update()
        update.set("description", item.description)
        update.set("quantity", item.quantity)
        update.set("storeId", item.storeId)
        update.set("unitPrice", item.unitPrice)

        return repository.update(query, update)
    }


}