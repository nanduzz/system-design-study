package systemdesignstudy

import dev.fernandocarvalho.systemdesignstudy.infra.kafka.consumer.KafkaConfigurator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(KafkaConfigurator::class)
class SystemDesignStudyApplication

fun main(args: Array<String>) {
    runApplication<SystemDesignStudyApplication>(*args)
}
