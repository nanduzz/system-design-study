package dev.fernandocarvalho.systemdesignstudy.order

import dev.fernandocarvalho.systemdesignstudy.infra.kafka.KafkaConfigurator
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Import

@EnableCaching
@ImportAutoConfiguration(
    classes = [CacheAutoConfiguration::class, RedisAutoConfiguration::class]
)
@SpringBootApplication
@Import(KafkaConfigurator::class)
class SystemDesignStudyApplication

fun main(args: Array<String>) {
    runApplication<SystemDesignStudyApplication>(*args)
}
