package com.lpnu.iot.term2.lab8.structure;


import com.lpnu.iot.term2.lab8.recources.Weapon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public Map<Long, Weapon> getWeapons() {
        return weaponRepository.findAll().stream().collect(Collectors.toMap(Weapon::getId, weapon -> weapon));
    }

    public Weapon getWeaponById(Long id) {
        var found = weaponRepository.findById(id);

        if(found.isPresent()) {
            return found.get();
        }
        else {
            throw new IllegalStateException("Did not find any weapons with id: " + id);
        }
    }

    public void saveWeapon(Weapon newWeapon) {
        weaponRepository.save(newWeapon);
    }

    public Weapon addWeapon(int quality) {

        var weapon = new Weapon();
        weapon.quality = quality;

        weaponRepository.save(weapon);

        return weapon;
    }

    public boolean deleteWeaponById(Long id) {
        if(!weaponRepository.existsById(id)) {
            return false;
        }

        weaponRepository.deleteById(id);
        return true;
    }

    @Transactional
    public boolean updateWeapon(Long id, int quality) {
        if(!weaponRepository.existsById(id)) {
            return false;
        }

        var retrieved_weapon = weaponRepository.findById(id).get();

        if(quality > 0 && retrieved_weapon.getQuality() != quality) {
            retrieved_weapon.setQuality(quality);
        }

        return true;
    }
}
