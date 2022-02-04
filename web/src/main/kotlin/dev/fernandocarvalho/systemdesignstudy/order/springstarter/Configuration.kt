package dev.fernandocarvalho.systemdesignstudy.order.springstarter

import dev.fernandocarvalho.systemdesignstudy.order.business.*
import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import dev.fernandocarvalho.systemdesignstudy.order.springstarter.components.KafkaSender
import dev.fernandocarvalho.systemdesignstudy.order.springstarter.database.OrderRepositoryImpl
import dev.fernandocarvalho.systemdesignstudy.order.springstarter.database.SpringOrderRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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

