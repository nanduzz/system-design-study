package systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business

import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

class OrderListenerImpl : OrderListener {
    override fun onNewOrder(order: Order) {
        println("Received a new order $order")
    }
}
