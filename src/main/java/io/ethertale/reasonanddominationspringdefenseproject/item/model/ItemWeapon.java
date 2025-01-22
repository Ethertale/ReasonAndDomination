package io.ethertale.reasonanddominationspringdefenseproject.item.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemWeapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String image;
    @Column
    @Enumerated(EnumType.STRING)
    ItemTypeWeapon type;
    @Column(nullable = false)
    ItemRarity rarity;
    @Column
    private String description;
    @Column
    private int strength;
    @Column
    private int agility;
    @Column
    private int intellect;
    @Column
    private int stamina;
    @Column
    private int spirit;
    @Column(name = "min_damage")
    private int minDamage;
    @Column(name = "max_damage")
    private int maxDamage;

}
