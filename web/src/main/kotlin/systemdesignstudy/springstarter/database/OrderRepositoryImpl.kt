package systemdesignstudy.springstarter.database

import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderRepository
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

class OrderRepositoryImpl(
    private val repository: SpringOrderRepository
) : OrderRepository {
    override fun save(order: Order): Order {
        val document = OrderDocument.fromOrder(order)
        return repository.save(document).toOrder()
    }

    override fun findAll(): List<Order> {
        return repository.findAll().map { it.toOrder() }
    }
}
