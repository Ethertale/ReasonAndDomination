package io.ethertale.reasonanddominationspringdefenseproject.item.service;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemTypeWeapon;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWeapon;

public interface ItemWeaponService {
    ItemWeapon createItem(String name,
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
                          int maxDamage);
}
