package com.example.order.adapters.infrastructure.clientRest

import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDate
import java.util.*


class OrderClient(private val template: RestTemplate) {

    companion object {
        const val ORDER_URL = "http://localhost:8080/api/order/v1/orders"
    }

    fun update(id: String, paymentDate: LocalDate) {
        val params = HashMap<String, LocalDate>()
        params["confirmationDate"] = paymentDate
        template.patchForObject("$ORDER_URL/$id", params, ResponseEntityExceptionHandler::class.java)
    }

}