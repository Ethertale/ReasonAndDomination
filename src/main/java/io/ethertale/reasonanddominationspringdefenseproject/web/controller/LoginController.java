package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final ProfileRepo profileRepo;
    private final ProfileService profileService;

    public LoginController(ProfileRepo profileRepo, ProfileService profileService) {
        this.profileRepo = profileRepo;
        this.profileService = profileService;
    }

    protected String loginMessage = "";

    @GetMapping
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("message", loginMessage);
        loginMessage = "";
        modelAndView.setViewName("login");
        modelAndView.addObject("form", new FormLoginDTO());
        return modelAndView;
    }

    @PostMapping
    public String loginProfile(@ModelAttribute FormLoginDTO formLoginDTO, Model model) {
        if (profileRepo.existsByEmailAndPassword(formLoginDTO.getEmail(), formLoginDTO.getPassword()) ){
            System.out.println("User Exists");
            return "redirect:/";
        }else {
            model.addAttribute("message", loginMessage);
            loginMessage = "Wrong email or password";
            System.out.println("User Doesn't Exist");
            return "redirect:/login";
        }

    }
}
