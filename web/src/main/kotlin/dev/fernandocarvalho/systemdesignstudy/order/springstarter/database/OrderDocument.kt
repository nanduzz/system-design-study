package dev.fernandocarvalho.systemdesignstudy.order.springstarter.database

import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import org.springframework.data.mongodb.core.mapping.Document

@Document("dev/fernandocarvalho/systemdesignstudy/order")
data class OrderDocument(
    val id: String,
    val name: String,
) {
    companion object {
        fun fromOrder(order: Order): OrderDocument {
            return OrderDocument(
                order.id,
                order.name
            )
        }
    }

    fun toOrder(): Order {
        return Order(
            id = id,
            name = name
        )
    }
}
