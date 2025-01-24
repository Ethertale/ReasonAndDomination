package io.ethertale.reasonanddominationspringdefenseproject.item.service;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.Item;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemType;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWear;

public interface ItemService {
    Item createItem(String name,
                    String imageLink,
                    ItemType type,
                    ItemRarity rarity,
                    String description,
                    int armour,
                    int strength,
                    int agility,
                    int intellect,
                    int stamina,
                    int spirit,
                    int minDamage,
                    int maxDamage);
}
