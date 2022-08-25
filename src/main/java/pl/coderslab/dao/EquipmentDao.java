package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Hero;
import pl.coderslab.game_objects.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EquipmentDao {
    @PersistenceContext
    EntityManager entityManager;

    public Equipment findById (long id){
        return entityManager.find(Equipment.class, id);
    }

    public List<Equipment> findAll(){
        Query query = entityManager.createQuery("select i from Item i");
        return query.getResultList();
    }

    public void saveEquipment(Equipment equipment){
        entityManager.persist(equipment);
    }

    public void deleteEquipment(Equipment equipment){
        entityManager.remove(entityManager.contains(equipment) ? equipment : entityManager.merge(equipment));
    }

    public void updateEquipment(Equipment equipment){
        entityManager.merge(equipment);
    }
}
