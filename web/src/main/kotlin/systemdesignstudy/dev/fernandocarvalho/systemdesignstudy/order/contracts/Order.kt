package systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts

import java.util.*

data class Order(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "order name"
)

