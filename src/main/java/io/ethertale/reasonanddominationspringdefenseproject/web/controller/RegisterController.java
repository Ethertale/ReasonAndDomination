package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountRole;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountStatus;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileServiceImpl;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final ProfileRepo profileRepo;
    private final ProfileService profileService;

    public RegisterController(ProfileRepo profileRepo, ProfileService profileService) {
        this.profileRepo = profileRepo;
        this.profileService = profileService;
    }

    protected String registerMessage = "";

    @GetMapping
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("message", registerMessage);
        registerMessage = "";
        mav.addObject("form", new FormRegisterDTO());
        mav.setViewName("register");
        return mav;
    }

    @PostMapping
    public String registerProfile(@ModelAttribute FormRegisterDTO formRegisterDTO, Model model) {
        if (profileRepo.existsByUsername(formRegisterDTO.getUsername())){
            model.addAttribute("message", registerMessage);
            registerMessage = "Username already exists";
            System.out.println("Username already exists");
            return "redirect:/register";
        } else if (profileRepo.existsByEmail(formRegisterDTO.getEmail())) {
            model.addAttribute("message", registerMessage);
            registerMessage = "Email already exists";
            System.out.println("Email already exists");
            return "redirect:/register";
        }

        registerMessage = "";
        profileService.registerProfile(formRegisterDTO.getUsername(), formRegisterDTO.getPassword(), formRegisterDTO.getEmail());

        return "redirect:/login";
    }

}
