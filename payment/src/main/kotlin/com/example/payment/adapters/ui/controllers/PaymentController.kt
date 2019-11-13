package com.example.store.adapters.ui.controllers

import com.example.payment.applicationCore.operations.CreatePaymentOperation
import com.example.payment.applicationCore.operations.GetPaymentByIdOperation
import com.example.payment.applicationCore.operations.UpdatePaymentOperation
import com.example.store.applicationCore.domain.entities.Payment
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/payment/v1/payments")
class PaymentController(val createPaymentOperation: CreatePaymentOperation,
                        val getPaymentByIdOperation: GetPaymentByIdOperation,
                        val updatePaymentOperation: UpdatePaymentOperation) {

    @PostMapping
    fun create(@RequestBody payment: Payment) = createPaymentOperation.execute(payment)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = getPaymentByIdOperation.execute(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody payment: Payment) = updatePaymentOperation.execute(id, payment)
}