package systemdesignstudy.springstarter.components

import dev.fernandocarvalho.systemdesignstudy.infra.kafka.model.CorrelationId
import dev.fernandocarvalho.systemdesignstudy.infra.kafka.model.Message
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import systemdesignstudy.dev.fernandocarvalho.systemdesignstudy.order.MessageSender

@Component
class KafkaSender<V>(
    val kafkaTemplate: KafkaTemplate<String, Message<V>>
) : MessageSender<V> {
    override fun send(destination: String, key: String, correlationId: String, value: V) {
        kafkaTemplate.send(
            destination,
            key,
            Message(CorrelationId(correlationId), value)
        )
    }
}
