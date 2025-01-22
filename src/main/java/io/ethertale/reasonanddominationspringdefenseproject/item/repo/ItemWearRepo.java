package io.ethertale.reasonanddominationspringdefenseproject.item.repo;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWeapon;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemWearRepo extends JpaRepository<ItemWear, Long> {
    boolean existsByName(String name);
}
