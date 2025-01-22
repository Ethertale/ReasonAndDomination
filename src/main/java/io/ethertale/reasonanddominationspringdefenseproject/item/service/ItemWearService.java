package io.ethertale.reasonanddominationspringdefenseproject.item.service;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemTypeWear;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWear;

public interface ItemWearService {
    ItemWear createTestItem();
    ItemWear createItem(String name,
                        String imageLink,
                        ItemTypeWear type,
                        ItemRarity rarity,
                        String description,
                        int armour,
                        int strength,
                        int agility,
                        int intellect,
                        int stamina,
                        int spirit);
}
