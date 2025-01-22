package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    ProfileService profileService;
    ProfileRepo profileRepo;

    public ProfileController(ProfileService profileService, ProfileRepo profileRepo) {
        this.profileService = profileService;
        this.profileRepo = profileRepo;
    }

    @GetMapping("/{id}")
    public ModelAndView profile(@PathVariable UUID id) {
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfile", profileRepo.findById(id));
        modelAndView.setViewName("profile");
        return modelAndView;
    }

}
