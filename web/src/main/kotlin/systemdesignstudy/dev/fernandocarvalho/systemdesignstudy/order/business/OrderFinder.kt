package systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business

import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

interface OrderFinder {
    fun findAll(): List<Order>
}
