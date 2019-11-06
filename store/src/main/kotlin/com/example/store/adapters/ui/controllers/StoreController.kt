package com.example.store.adapters.ui.controllers

import com.example.store.applicationCore.domain.model.Store
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/store/v1/stores")
class StoreController {

    @PostMapping
    fun create(@RequestBody store: Store): String {
        return "create"
    }

    @GetMapping
    fun find(@RequestParam name: String, address: String): String {
        return "find"
    }

    @PutMapping("/{storeId}")
    fun update(@PathVariable storeId: String, @RequestBody store: Store): String {
        return "update"
    }

}