package spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.repository.ItemRepository;
import spring.boot.kafka.mongo.microservices.springbootkafkamongomicroservices.repository.pojo.Items;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository ;


    public Items createItem(Items item) {
        return itemRepository.save(item);
    }


    public Boolean updateItem(Items item) throws Exception {
        Optional<Items> itemOpt = itemRepository.findById(item.getItemId());
        if(itemOpt.isPresent()){
            Items itemRep = itemOpt.get();
            itemRep.setItemName(item.getItemName());
            itemRep.setItemDesc(item.getItemDesc());
            itemRep.setItemAmount(item.getItemAmount());
            itemRep.setUpdatedBy("Abhishek");
            itemRep.setUpdationDate(LocalDateTime.now());
            itemRepository.save(itemRep);
        return true;
        }else{
            throw new Exception("Item Not Found in Db");

        }

    }

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }


    public Items getItemById(Integer itemId) {
        Optional<Items> optItem = itemRepository.findById(itemId);
        if(optItem.isPresent()){
            return optItem.get();
        }
        return null;
    }


    public List<Items> getItemByName(String itemName) {
        return null;
    }


    public Boolean deleteItem(Integer itemId) {
        Optional<Items> optItem = itemRepository.findById(itemId);
        if(optItem.isPresent()) {
            itemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }
}
