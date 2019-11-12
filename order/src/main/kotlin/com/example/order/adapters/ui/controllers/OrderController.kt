package com.example.order.adapters.ui.controllers

import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.operations.CreateOrderOperation
import com.example.order.applicationCore.operations.GetByIdOrderOperation
import com.example.order.applicationCore.operations.GetUpdateOperation
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/order/v1/orders")
class OrderController(val createOrderOperation: CreateOrderOperation,
                      val getByIdOrderOperation: GetByIdOrderOperation,
                      val getUpdateOperation: GetUpdateOperation) {

    @PostMapping
    fun create(@RequestBody order: Order) = createOrderOperation.execute(order)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = getByIdOrderOperation.execute(id)

    @PatchMapping("{/id}")
    fun update(@PathVariable id: String, @RequestParam confirmationDate: LocalDate?) = getUpdateOperation.execute(id, confirmationDate)

}