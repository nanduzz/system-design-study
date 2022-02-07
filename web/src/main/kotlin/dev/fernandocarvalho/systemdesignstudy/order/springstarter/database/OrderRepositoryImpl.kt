package dev.fernandocarvalho.systemdesignstudy.order.springstarter.database

import dev.fernandocarvalho.systemdesignstudy.order.business.OrderRepository
import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import org.springframework.cache.annotation.Cacheable

open class OrderRepositoryImpl(
    private val repository: SpringOrderRepository
) : OrderRepository {
    override fun save(order: Order): Order {
        val document = OrderDocument.fromOrder(order)
        return repository.save(document).toOrder()
    }

    @Cacheable(value = ["orders"])
    override fun findAll(): List<Order> {
        Thread.sleep(3000) // 3 seconds to simulate soma heavy processing
        return repository.findAll().map { it.toOrder() }
    }
}
