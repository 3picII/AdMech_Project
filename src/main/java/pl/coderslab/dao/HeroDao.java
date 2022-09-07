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

    public Hero findByName (String name){
        return (Hero) entityManager.createQuery("select h from Hero h where h.name = :name")
                .setParameter("name",name)
                .getSingleResult();
    }

    public List<Hero> findAll(){
        Query query = entityManager.createQuery("select h from Hero h");
        return query.getResultList();
    }

    public void saveHero(Hero hero){
        entityManager.persist(hero  );
    }

    public void deleteHero(Hero hero){
        entityManager.remove(entityManager.contains(hero) ? hero : entityManager.merge(hero));
    }

    public void updateHero (Hero hero){
        entityManager.merge(hero);
    }
}
