package dev.fernandocarvalho.systemdesignstudy.order

interface MessageSender<V> {
    fun send(destination: String, key: String, correlationId: String, value: V)
}
