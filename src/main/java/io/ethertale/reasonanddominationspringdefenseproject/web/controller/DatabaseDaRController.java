package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import io.ethertale.reasonanddominationspringdefenseproject.dungeon.repo.DungeonRepo;
import io.ethertale.reasonanddominationspringdefenseproject.heroRace.repo.HeroRaceRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWeapon;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemWeaponRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemWearRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.service.ItemWeaponService;
import io.ethertale.reasonanddominationspringdefenseproject.item.service.ItemWearService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ItemWeaponDTO;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ItemWearDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;

@Controller
@RequestMapping("/database-dar")
public class DatabaseDaRController {

    HeroRaceRepo heroRaceRepo;
    DungeonRepo dungeonRepo;
    ProfileRepo profileRepo;
    ItemWearRepo itemWearRepo;
    ItemWeaponRepo itemWeaponRepo;

    ProfileService profileService;
    ItemWearService itemWearService;
    ItemWeaponService itemWeaponService;

    public DatabaseDaRController(HeroRaceRepo heroRaceRepo, DungeonRepo dungeonRepo, ProfileRepo profileRepo, ItemWearRepo itemWearRepo, ItemWeaponRepo itemWeaponRepo, ProfileService profileService, ItemWearService itemWearService, ItemWeaponService itemWeaponService) {
        this.heroRaceRepo = heroRaceRepo;
        this.dungeonRepo = dungeonRepo;
        this.profileRepo = profileRepo;
        this.itemWearRepo = itemWearRepo;
        this.itemWeaponRepo = itemWeaponRepo;
        this.profileService = profileService;
        this.itemWearService = itemWearService;
        this.itemWeaponService = itemWeaponService;
    }

    @GetMapping
    public ModelAndView databaseDaR(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("profiles", profileRepo.findAll().stream().sorted(Comparator.comparing(Profile::getCreatedOn).reversed()));
        modelAndView.addObject("dar", dungeonRepo.findAll());
        modelAndView.addObject("races", heroRaceRepo.findAll());
        modelAndView.addObject("itemWears", itemWearRepo.findAll());
        modelAndView.addObject("itemWeapons", itemWeaponRepo.findAll());
        modelAndView.addObject("formWear", new ItemWearDTO());
        modelAndView.addObject("formWeapon", new ItemWeaponDTO());
        modelAndView.setViewName("database-dar");
        return modelAndView;
        // TODO Implement wear and weapon POST creation
    }

    @PostMapping("/item-wear-create")
    public String createItemWear(@ModelAttribute ItemWearDTO itemWearDTO, Model model) {
        if (!itemWearRepo.existsByName(itemWearDTO.getName())) {
            itemWearService.createItem(itemWearDTO.getName(),
                    itemWearDTO.getImageLink(),
                    itemWearDTO.getType(),
                    itemWearDTO.getRarity(),
                    itemWearDTO.getDescription(),
                    itemWearDTO.getArmour(),
                    itemWearDTO.getStrength(),
                    itemWearDTO.getAgility(),
                    itemWearDTO.getIntellect(),
                    itemWearDTO.getStamina(),
                    itemWearDTO.getSpirit());

        }
        return "redirect:/database-dar";
    }

    //TODO Return Custom Error for item up and below

    @PostMapping("/item-weapon-create")
    public String createItemWeapon(@ModelAttribute ItemWeaponDTO itemWeaponDTO, Model model) {
        if (!itemWeaponRepo.existsByName(itemWeaponDTO.getName())) {
            itemWeaponService.createItem(itemWeaponDTO.getName(),
                    itemWeaponDTO.getImageLink(),
                    itemWeaponDTO.getType(),
                    itemWeaponDTO.getRarity(),
                    itemWeaponDTO.getDescription(),
                    itemWeaponDTO.getStrength(),
                    itemWeaponDTO.getAgility(),
                    itemWeaponDTO.getIntellect(),
                    itemWeaponDTO.getStamina(),
                    itemWeaponDTO.getSpirit(),
                    itemWeaponDTO.getMinDamage(),
                    itemWeaponDTO.getMaxDamage());

        }
        return "redirect:/database-dar";
    }
}
