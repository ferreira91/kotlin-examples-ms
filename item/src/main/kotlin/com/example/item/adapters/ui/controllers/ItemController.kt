package com.example.item.adapters.ui.controllers

import com.example.item.applicationCode.application.operation.CreateItemOperation
import com.example.item.applicationCode.application.operation.GetItemByIdOperation
import com.example.item.applicationCode.application.operation.GetItemOperation
import com.example.item.applicationCode.application.operation.UpdateItemOperation
import com.example.item.applicationCode.domain.model.Item
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item/v1/items")
class ItemController(val createItemOperation: CreateItemOperation,
                     val getItemByIdOperation: GetItemByIdOperation,
                     val getItemOperation: GetItemOperation,
                     val updateItemOperation: UpdateItemOperation) {

    @PostMapping
    fun create(@RequestBody item: Item) = createItemOperation.execute(item)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = getItemByIdOperation.execute(id)

    @GetMapping
    fun find(@RequestParam storeId: String?) = getItemOperation.execute(storeId)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody item: Item) = updateItemOperation.execute(id, item)
}