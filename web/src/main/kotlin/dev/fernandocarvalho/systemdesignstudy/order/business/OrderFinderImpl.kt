package dev.fernandocarvalho.systemdesignstudy.order.business

import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

class OrderFinderImpl(
    private val orderRepository: OrderRepository
) : OrderFinder {

    override fun findAll(): List<Order> {
        return orderRepository.findAll()
    }

}
