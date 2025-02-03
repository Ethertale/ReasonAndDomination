package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountRole;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountStatus;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileServiceImpl;
import io.ethertale.reasonanddominationspringdefenseproject.dungeon.repo.DungeonRepo;
import io.ethertale.reasonanddominationspringdefenseproject.heroRace.model.HeroRace;
import io.ethertale.reasonanddominationspringdefenseproject.heroRace.repo.HeroRaceRepo;
import io.ethertale.reasonanddominationspringdefenseproject.playerCharacter.model.Hero;
import io.ethertale.reasonanddominationspringdefenseproject.playerCharacter.model.HeroClasses;
import io.ethertale.reasonanddominationspringdefenseproject.playerCharacter.model.HeroRaces;
import io.ethertale.reasonanddominationspringdefenseproject.playerCharacter.repo.HeroRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController {

    DungeonRepo dungeonRepo;
    HeroRaceRepo heroRaceRepo;
    HeroRepository heroRepo;
    ProfileRepo profileRepo;
    ProfileService profileService;

    public HomeController(DungeonRepo dungeonRepo, HeroRaceRepo heroRaceRepo, HeroRepository heroRepo, ProfileRepo profileRepo, ProfileService profileService) {
        this.dungeonRepo = dungeonRepo;
        this.heroRaceRepo = heroRaceRepo;
        this.heroRepo = heroRepo;
        this.profileRepo = profileRepo;
        this.profileService = profileService;
    }

    @GetMapping
    public ModelAndView index(HttpSession session) {

        UUID user_id = (UUID) session.getAttribute("user_id");
        Profile user = profileService.getProfileById(UUID.fromString(user_id.toString()));

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/player-lookup")
    public String playerLookup(Model model) {
        return "player-lookup";
    }


}
