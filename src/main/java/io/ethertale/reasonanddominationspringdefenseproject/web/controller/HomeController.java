package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.dungeon.repo.DungeonRepo;
import io.ethertale.reasonanddominationspringdefenseproject.heroRace.model.HeroRace;
import io.ethertale.reasonanddominationspringdefenseproject.heroRace.repo.HeroRaceRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    DungeonRepo dungeonRepo;
    HeroRaceRepo heroRaceRepo;

    public HomeController(DungeonRepo dungeonRepo, HeroRaceRepo heroRaceRepo) {
        this.dungeonRepo = dungeonRepo;
        this.heroRaceRepo = heroRaceRepo;
    }

    @GetMapping({"", "/"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/database-dar")
    public String databaseDar(Model dars, Model races) {
        dars.addAttribute("dar", dungeonRepo.findAll());
        races.addAttribute("races", heroRaceRepo.findAll());
        return "database-dar";
    }
}
