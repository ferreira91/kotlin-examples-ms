package com.example.item.adapters.ui.controllers

import com.example.item.applicationCode.domain.model.Item
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item/v1/items")
class ItemController {

    @PostMapping
    fun create(@RequestBody item: Item) = ""

    @GetMapping("/{storeId}/stores/{id}")
    fun findByStoreIdAndId(@PathVariable storeId: String, id: String) = ""

    @GetMapping("/{storeId}")
    fun findByStoreId(@PathVariable storeId: String) = ""

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody item: Item) = ""
}