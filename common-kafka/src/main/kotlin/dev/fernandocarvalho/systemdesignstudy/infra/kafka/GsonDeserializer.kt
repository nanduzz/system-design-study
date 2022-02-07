package dev.fernandocarvalho.systemdesignstudy.infra.kafka

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dev.fernandocarvalho.systemdesignstudy.infra.kafka.model.Message
import org.apache.kafka.common.serialization.Deserializer

class GsonDeserializer<T> : Deserializer<Message<T>> {

    private val gson: Gson = GsonBuilder().registerTypeAdapter(Message::class.java, MessageAdapter<T>()).create()

    override fun deserialize(p0: String?, bytes: ByteArray?): Message<T> {
        val data = bytes?.let { String(it) }
        return gson.fromJson(data, Message::class.java) as Message<T>
    }

}
