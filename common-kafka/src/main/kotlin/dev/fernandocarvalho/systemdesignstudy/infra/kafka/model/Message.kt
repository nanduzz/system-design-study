package dev.fernandocarvalho.systemdesignstudy.infra.kafka.model

data class Message<T>(
    val id: CorrelationId,
    val payload: T
)

