package com.example.item.adapters.ui.controllers

import com.example.item.applicationCode.application.operation.CreateItemOperation
import com.example.item.applicationCode.application.operation.GetItemOperation
import com.example.item.applicationCode.application.operation.UpdateItemOperation
import com.example.item.applicationCode.domain.model.Item
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item/v1/items")
class ItemController(val createItemOperation: CreateItemOperation,
                     val getItemOperation: GetItemOperation,
                     val updateItemOperation: UpdateItemOperation) {

    @PostMapping
    fun create(@RequestBody item: Item) = createItemOperation.execute(item)

    @GetMapping("/{storeId}/stores/{id}")
    fun findByStoreIdAndId(@PathVariable storeId: String, id: String) = getItemOperation.execute(storeId, id)

    @GetMapping("/{storeId}")
    fun findByStoreId(@PathVariable storeId: String) = getItemOperation.execute(storeId)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody item: Item) = updateItemOperation.execute(id, item)
}