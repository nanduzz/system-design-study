package dev.fernandocarvalho.systemdesignstudy.order.business

import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

interface OrderListener {
    fun onNewOrder(order: Order)
}
