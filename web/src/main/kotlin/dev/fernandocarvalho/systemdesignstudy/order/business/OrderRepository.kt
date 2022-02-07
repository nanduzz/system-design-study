package dev.fernandocarvalho.systemdesignstudy.order.business

import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

interface OrderRepository {

    fun save(order: Order): Order
    fun findAll(): List<Order>

}
