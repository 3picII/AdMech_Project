package pl.coderslab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Hero;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;

    public Hero findById(long id){
        return heroDao.findById(id);
    }

    public List<Hero> findAll(){
        return heroDao.findAll();
    }

    public void saveHero(Hero hero){
        heroDao.saveHero(hero);
    }

    public void deleteHero(Hero hero){
        heroDao.deleteHero(hero);
    }

    public void updateHero(Hero hero){
        heroDao.updateHero(hero);
    }
}
