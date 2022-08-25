package pl.coderslab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.game_objects.Item;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemDao itemDao;

    public Item findById(long id){
        return itemDao.findById(id);
    }

    public List<Item> findAll(){
        return itemDao.findAll();
    }

    public void saveItem(Item item){
        itemDao.saveItem(item);
    }

    public void deleteItem(Item item){
        itemDao.deleteItem(item);
    }

    public void updateItem(Item item){
        itemDao.updateItem(item);
    }
}
