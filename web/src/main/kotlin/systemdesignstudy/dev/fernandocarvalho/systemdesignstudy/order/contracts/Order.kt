package systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts

import java.util.*

data class Order(
    val uuid: UUID = UUID.randomUUID(),
    val name: String = "order name"
)

