package com.example.item.adapters.infrastructure.database.mongodb

import com.example.item.applicationCode.domain.model.Item
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
class ItemRepository(val template: MongoTemplate) {

    fun save(item: Item): Item = template.save(item)
    fun findById(id: String): Item? = template.findById(id, Item::class.java)
    fun find(query: Query): List<Item> = template.find(query, Item::class.java)
    fun update(query: Query, update: Update): Item = template.findAndModify(query, update, FindAndModifyOptions().returnNew(true), Item::class.java)!!
}
