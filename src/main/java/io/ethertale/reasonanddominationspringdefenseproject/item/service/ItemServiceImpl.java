package io.ethertale.reasonanddominationspringdefenseproject.item.service;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.Item;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemType;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWear;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemRepo;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    ItemRepo repo;

    public ItemServiceImpl(ItemRepo repo) {
        this.repo = repo;
    }

    @Override
    public Item createItem(String name,
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
                           int maxDamage) {

        Item newItem = Item.builder()
                .name(name)
                .image(imageLink)
                .type(type)
                .rarity(rarity)
                .description(description)
                .armour(armour)
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
