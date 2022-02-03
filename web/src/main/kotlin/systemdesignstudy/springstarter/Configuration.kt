package systemdesignstudy.springstarter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.*
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import systemdesignstudy.springstarter.components.KafkaSender
import systemdesignstudy.springstarter.database.OrderRepositoryImpl
import systemdesignstudy.springstarter.database.SpringOrderRepository

@Configuration
class OrderConfiguration {

    @Bean
    fun orderRepository(springOrderRepository: SpringOrderRepository): OrderRepository {
        return OrderRepositoryImpl(springOrderRepository)
    }

    @Bean
    fun orderListener(orderRepository: OrderRepository): OrderListener {
        return OrderListenerImpl(orderRepository)
    }

    @Bean
    fun orderDispatcher(orderSender: KafkaSender<Order>): OrderDispatcher {
        return OrderDispatcher(orderSender)
    }

    @Bean
    fun orderFinder(orderRepository: OrderRepository): OrderFinder {
        return OrderFinderImpl(orderRepository)
    }
}

