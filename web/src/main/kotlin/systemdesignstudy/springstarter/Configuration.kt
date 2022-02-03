package systemdesignstudy.springstarter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderDispatcher
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderListener
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderListenerImpl
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import systemdesignstudy.springstarter.components.KafkaSender

@Configuration
class OrderConfiguration {

    @Bean
    fun orderListener(): OrderListener {
        return OrderListenerImpl()
    }

    @Bean
    fun orderDispatcher(orderSender: KafkaSender<Order>): OrderDispatcher {
        return OrderDispatcher(orderSender)
    }
}

