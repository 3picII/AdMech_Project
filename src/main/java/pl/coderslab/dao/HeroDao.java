package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Hero;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HeroDao {
    @PersistenceContext
    EntityManager entityManager;

    public Hero findById (long id){
        return entityManager.find(Hero.class, id);
    }

    public List<Hero> findAll(){
        Query query = entityManager.createQuery("select i from Item i");
        return query.getResultList();
    }

    public void saveHero(Hero hero){
        entityManager.persist(hero  );
    }

    public void deleteHero(Hero hero){
        entityManager.remove(entityManager.contains(hero) ? hero : entityManager.merge(hero));
    }
}
