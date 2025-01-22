package io.ethertale.reasonanddominationspringdefenseproject.web.dto;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemRarity;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemTypeWeapon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ItemWeaponDTO {
    private String name;
    private String imageLink;
    private ItemTypeWeapon type;
    private ItemRarity rarity;
    private String description;
    private int strength;
    private int agility;
    private int intellect;
    private int stamina;
    private int spirit;
    private int minDamage;
    private int maxDamage;
}
