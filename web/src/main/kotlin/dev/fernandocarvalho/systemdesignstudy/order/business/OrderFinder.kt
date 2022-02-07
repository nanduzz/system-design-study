package dev.fernandocarvalho.systemdesignstudy.order.business

import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

interface OrderFinder {
    fun findAll(): List<Order>
}
