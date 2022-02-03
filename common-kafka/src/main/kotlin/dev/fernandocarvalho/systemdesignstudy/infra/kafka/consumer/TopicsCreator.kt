package dev.fernandocarvalho.systemdesignstudy.infra.kafka.consumer

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TopicsCreator {

    @Bean
    fun topic() = NewTopic("topic1", 3, 3)

    @Bean
    fun topic2() = NewTopic("topic2", 3, 3)

    @Bean
    fun topic3() = NewTopic("topic3", 3, 3)

    @Bean
    fun topicNewOrder() = NewTopic(
        "dev_fernandocarvalho_NEW_ORDER",
        3,
        3
    )
}
