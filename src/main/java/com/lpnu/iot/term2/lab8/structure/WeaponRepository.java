package com.lpnu.iot.term2.lab8.structure;

import com.lpnu.iot.term2.lab8.recources.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
