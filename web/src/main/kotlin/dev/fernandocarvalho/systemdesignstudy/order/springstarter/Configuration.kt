package dev.fernandocarvalho.systemdesignstudy.order.springstarter

import dev.fernandocarvalho.systemdesignstudy.order.business.*
import dev.fernandocarvalho.systemdesignstudy.order.contracts.Order
import dev.fernandocarvalho.systemdesignstudy.order.springstarter.components.KafkaSender
import dev.fernandocarvalho.systemdesignstudy.order.springstarter.database.OrderRepositoryImpl
import dev.fernandocarvalho.systemdesignstudy.order.springstarter.database.SpringOrderRepository
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

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

    //redis
    @Bean
    fun cacheConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(60))
            .disableCachingNullValues()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                    GenericJackson2JsonRedisSerializer()
                )
            )
    }

    @Bean
    fun redisCacheManagerBuilderCustomizer(): RedisCacheManagerBuilderCustomizer {
        return RedisCacheManagerBuilderCustomizer { builder: RedisCacheManager.RedisCacheManagerBuilder ->
            builder
                .withCacheConfiguration(
                    "itemCache",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(10))
                )
                .withCacheConfiguration(
                    "customerCache",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(5))
                )
        }
    }
}

