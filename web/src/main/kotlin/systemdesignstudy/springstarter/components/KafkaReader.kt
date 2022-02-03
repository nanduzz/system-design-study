package systemdesignstudy.springstarter.components

import dev.fernandocarvalho.systemdesignstudy.infra.kafka.model.Message
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderDispatcher
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.business.OrderListener
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.contracts.Order

@Component
class KafkaReader(
    val orderListener: OrderListener
) {

    companion object {
        const val GROUP_NAME = "KafkaReader"
    }

    @KafkaListener(id = GROUP_NAME, topics = [OrderDispatcher.TOPIC])
    fun listen(
        @Payload message: Message<Order>,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int,
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: String,
    ) {
        println("Partition: $partition // topic: $topic // key: $key")
        println("Consumed $message")
        orderListener.onNewOrder(message.payload)
    }

}
