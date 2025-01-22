package io.ethertale.reasonanddominationspringdefenseproject.item.service;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemTypeWear;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWear;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemWearRepo;
import org.springframework.stereotype.Service;

@Service
public class ItemWearServiceImpl implements ItemWearService {

    ItemWearRepo repo;

    public ItemWearServiceImpl(ItemWearRepo repo) {
        this.repo = repo;
    }

    @Override
    public ItemWear createTestItem() {
        ItemWear item = ItemWear.builder()
                .name("The Frozen Seal")
                .image("https://www.hiveworkshop.com/data/ratory-images/146/146109-9b016f73861dfc0a2f9fc83cfef39e9b.jpg")
                .type(ItemTypeWear.FINGER)
                .rarity(ItemRarity.EPIC)
                .agility(5)
                .intellect(15)
                .spirit(11)
                .build();

        return item;
    }

    @Override
    public ItemWear createItem(String name,
                               String imageLink,
                               ItemTypeWear type,
                               ItemRarity rarity,
                               String description,
                               int armour,
                               int strength,
                               int agility,
                               int intellect,
                               int stamina,
                               int spirit) {

        ItemWear newItem = ItemWear.builder()
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
                .build();


        return repo.save(newItem);
    }

}
