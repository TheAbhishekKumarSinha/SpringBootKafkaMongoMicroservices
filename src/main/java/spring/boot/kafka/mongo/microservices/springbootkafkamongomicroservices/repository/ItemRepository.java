package spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.repository.pojo.Items;
@Repository
public interface ItemRepository extends MongoRepository<Items,Integer> {
}
