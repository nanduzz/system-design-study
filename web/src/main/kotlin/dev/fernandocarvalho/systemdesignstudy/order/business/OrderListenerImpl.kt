package dev.fernandocarvalho.systemdesignstudy.order.business

import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

class OrderListenerImpl(
    private val orderRepository: OrderRepository
) : OrderListener {

    override fun onNewOrder(order: Order) {
        println("Received a new order $order")
        orderRepository.save(order)
    }

}
