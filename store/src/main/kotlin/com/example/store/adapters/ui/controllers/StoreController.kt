package com.example.store.adapters.ui.controllers

import com.example.store.applicationCore.application.operation.CreateStoreOperation
import com.example.store.applicationCore.application.operation.GetStoreOperation
import com.example.store.applicationCore.application.operation.UpdateStoreOperation
import com.example.store.applicationCore.domain.model.Store
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/store/v1/stores")
class StoreController(val createStoreOperation: CreateStoreOperation,
                      val getStoreOperation: GetStoreOperation,
                      val updateStoreOperation: UpdateStoreOperation) {

    @PostMapping
    fun create(@RequestBody store: Store) = createStoreOperation.execute(store)

    @GetMapping
    fun find(@RequestParam name: String?, address: String?) = getStoreOperation.execute(name, address)

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.HEAD])
    fun exists(@PathVariable id: String) = getStoreOperation.exists(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody store: Store) = updateStoreOperation.execute(id, store)
}