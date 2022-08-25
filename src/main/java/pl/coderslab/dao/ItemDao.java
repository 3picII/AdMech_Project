package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.game_objects.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemDao {
    @PersistenceContext
    EntityManager entityManager;

    public Item findById (long id){
        return entityManager.find(Item.class, id);
    }

    public List<Item> findAll(){
        Query query = entityManager.createQuery("select i from Item i");
        return query.getResultList();
    }

    public void saveItem(Item item){
        entityManager.persist(item);
    }

    public void deleteItem(Item item){
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
    }

    public void updateItem(Item item){
        entityManager.merge(item);
    }
}
