package systemdesignstudy.springstarter.database

import org.springframework.data.mongodb.core.mapping.Document
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

@Document("order")
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
