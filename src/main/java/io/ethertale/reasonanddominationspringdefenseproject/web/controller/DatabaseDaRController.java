package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountRole;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import io.ethertale.reasonanddominationspringdefenseproject.dungeon.repo.DungeonRepo;
import io.ethertale.reasonanddominationspringdefenseproject.heroRace.repo.HeroRaceRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.service.ItemService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ItemDTO;
import jakarta.servlet.http.HttpSession;
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

    ItemRepo itemRepo;

    ProfileService profileService;
    ItemService itemService;


    public DatabaseDaRController(HeroRaceRepo heroRaceRepo, DungeonRepo dungeonRepo, ItemRepo itemRepo, ProfileService profileService, ItemService itemService) {
        this.heroRaceRepo = heroRaceRepo;
        this.dungeonRepo = dungeonRepo;

        this.itemRepo = itemRepo;
        this.profileService = profileService;
        this.itemService = itemService;
    }

    @GetMapping
    public ModelAndView databaseDaR(Model model, HttpSession session) {
        if (session.getAttribute("user_role") != AccountRole.ADMIN){
            return new ModelAndView("redirect:/home");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("profiles", profileService.getAllProfilesReversed());
        modelAndView.addObject("dar", dungeonRepo.findAll());
        modelAndView.addObject("races", heroRaceRepo.findAll());
        modelAndView.addObject("items", itemRepo.findAll());
        modelAndView.addObject("formItem", new ItemDTO());
        modelAndView.setViewName("database-dar");
        return modelAndView;
    }

    @PostMapping("/item-create")
    public String createItemWear(@ModelAttribute ItemDTO itemDTO, Model model) {
        if (!itemRepo.existsByName(itemDTO.getName())) {
            itemService.createItem(itemDTO.getName(),
                    itemDTO.getImageLink(),
                    itemDTO.getType(),
                    itemDTO.getRarity(),
                    itemDTO.getDescription(),
                    itemDTO.getArmour(),
                    itemDTO.getStrength(),
                    itemDTO.getAgility(),
                    itemDTO.getIntellect(),
                    itemDTO.getStamina(),
                    itemDTO.getSpirit(),
                    itemDTO.getMinDamage(),
                    itemDTO.getMaxDamage());
        }
        return "redirect:/database-dar";
    }

    //TODO Return Custom Error
    //TODO REMOVE ALL REPOS FROM CONTROLLERS
}
