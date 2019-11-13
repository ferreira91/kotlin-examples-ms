package com.example.payment.adapters.infrastructure.clientRest

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDate
import java.util.*

@Service
class OrderClient(val template: RestTemplate) {

    companion object {
        const val ORDER_URL = "http://localhost:8080/api/order/v1/orders"
    }

    fun update(id: String, orderId: String, paymentDate: LocalDate) {
        val params = HashMap<String, Any>()
        params["orderId"] = orderId
        params["confirmationDate"] = paymentDate
        template.patchForObject("$ORDER_URL/$id", params, ResponseEntityExceptionHandler::class.java)
    }

}