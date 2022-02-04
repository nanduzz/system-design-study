package dev.fernandocarvalho.systemdesignstudy.order.business

import dev.fernandocarvalho.systemdesignstudy.order.MessageSender
import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import java.util.*

class OrderDispatcher(
    private val messageSender: MessageSender<Order>
) {

    companion object {
        const val TOPIC = "dev_fernandocarvalho_NEW_ORDER"
    }

    fun sendMessage() {
        messageSender.send(
            TOPIC,
            UUID.randomUUID().toString().also { println(it) },
            OrderDispatcher::class.java.simpleName,
            Order()
        )
    }

}
