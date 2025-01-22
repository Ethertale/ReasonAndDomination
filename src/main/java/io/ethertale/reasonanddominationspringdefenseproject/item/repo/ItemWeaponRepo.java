package io.ethertale.reasonanddominationspringdefenseproject.item.repo;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWeapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemWeaponRepo extends JpaRepository<ItemWeapon, Long> {
    boolean existsByName(String name);
}
