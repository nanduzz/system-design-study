package dev.fernandocarvalho.systemdesignstudy.order.springstarter.web

import dev.fernandocarvalho.systemdesignstudy.order.business.OrderDispatcher
import dev.fernandocarvalho.systemdesignstudy.order.business.OrderFinder
import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1/order")
class OrderController(
    private val orderDispatcher: OrderDispatcher,
    private val orderFinder: OrderFinder
) {

    @PostMapping
    fun newOrder(): ResponseEntity<Void> {
        orderDispatcher.sendMessage()
        return ResponseEntity.ok(null)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderFinder.findAll())
    }
}
