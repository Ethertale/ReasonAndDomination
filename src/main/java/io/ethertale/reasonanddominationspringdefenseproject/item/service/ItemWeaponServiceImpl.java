package io.ethertale.reasonanddominationspringdefenseproject.item.service;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemTypeWeapon;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWeapon;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemWeaponRepo;
import org.springframework.stereotype.Service;

@Service
public class ItemWeaponServiceImpl implements ItemWeaponService{

    ItemWeaponRepo repo;

    public ItemWeaponServiceImpl(ItemWeaponRepo repo) {
        this.repo = repo;
    }

    @Override
    public ItemWeapon createItem(String name,
                                 String imageLink,
                                 ItemTypeWeapon type,
                                 ItemRarity rarity,
                                 String description,
                                 int strength,
                                 int agility,
                                 int intellect,
                                 int stamina,
                                 int spirit,
                                 int minDamage,
                                 int maxDamage) {
        ItemWeapon newItem = ItemWeapon.builder()
                .name(name)
                .image(imageLink)
                .type(type)
                .rarity(rarity)
                .description(description)
                .strength(strength)
                .agility(agility)
                .intellect(intellect)
                .stamina(stamina)
                .spirit(spirit)
                .minDamage(minDamage)
                .maxDamage(maxDamage)
                .build();

        return repo.save(newItem);
    }
}
