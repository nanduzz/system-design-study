package systemdesignstudy.springstarter.web

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderDispatcher

@Controller
@RequestMapping("/api/v1/order")
class OrderController(
    val orderDispatcher: OrderDispatcher
) {

    @PostMapping
    fun newOrder() : ResponseEntity<Void>{
        orderDispatcher.sendMessage()
        return ResponseEntity.ok(null)
    }
}
