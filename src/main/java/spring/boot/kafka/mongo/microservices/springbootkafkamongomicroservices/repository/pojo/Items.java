package spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.repository.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ITEMS")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Items {

    @Id
    private Integer itemId;
    private String itemName;
    private String itemDesc;
	private String itemAmount;
    private String createdBy;
    private LocalDateTime creationTime;
    private String updatedBy;
    private LocalDateTime updationDate;
	
}
