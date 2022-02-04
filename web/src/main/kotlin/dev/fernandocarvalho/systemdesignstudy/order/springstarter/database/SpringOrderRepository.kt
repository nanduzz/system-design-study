package dev.fernandocarvalho.systemdesignstudy.order.springstarter.database

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringOrderRepository : MongoRepository<OrderDocument, String>
