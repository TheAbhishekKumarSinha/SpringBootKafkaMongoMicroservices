package spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.repository.pojo.Items;
import spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<List<Items>> getAllItems(){
        return ResponseEntity.ok().body(itemService.getAllItems());
    }

    @PostMapping(value = "/", consumes = {"application/json"} )
    public ResponseEntity<Items> createItems(@RequestBody Items item){
        return ResponseEntity.ok().body(itemService.createItem(item));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Items> getItemByItemId(@PathVariable Integer itemId){

        if(itemService.getItemById(itemId)!=null){
            return ResponseEntity.ok().body(itemService.getItemById(itemId));
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping(value = "/", consumes = {"application/json"} )
    public ResponseEntity<Boolean> updateItem(@RequestBody Items item) throws Exception{
        return ResponseEntity.ok().body(itemService.updateItem(item));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity deleteItem(@PathVariable Integer itemId){
        return ResponseEntity.ok().body(itemService.deleteItem(itemId));
    }

}
