package pl.coderslab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Item;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentDao equipmentDao;

    public Equipment findById(long id){
        return equipmentDao.findById(id);
    }

    public List<Equipment> findAll(){
        return equipmentDao.findAll();
    }

    public void saveEquipment(Equipment equipment){
        equipmentDao.saveEquipment(equipment);
    }

    public void deleteEquipment(Equipment equipment){
        equipmentDao.deleteEquipment(equipment);
    }

    public void updateEquipment(Equipment equipment){
        equipmentDao.updateEquipment(equipment);
    }
}
