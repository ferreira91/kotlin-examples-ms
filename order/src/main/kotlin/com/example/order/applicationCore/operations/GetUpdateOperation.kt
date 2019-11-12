package com.example.order.applicationCore.operations

import com.example.order.applicationCore.domain.entities.Order
import com.example.order.applicationCore.persistence.OrderPersistence
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class GetUpdateOperation(val persistence: OrderPersistence) {
    fun execute(id: String, confirmationDate: LocalDate?): Order {
        return persistence.update(id, confirmationDate)
    }
}