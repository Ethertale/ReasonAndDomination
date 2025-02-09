package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.service.ProfileService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormLoginDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final ProfileService profileService;

    @Autowired
    public LoginController(ProfileService profileService) {
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
    public String loginProfile(@ModelAttribute FormLoginDTO formLoginDTO, HttpServletResponse response, HttpSession session) {
        Profile loggedUser = profileService.loginProfile(formLoginDTO);
        session.setAttribute("user_id", loggedUser.getId());
        session.setAttribute("user_name", loggedUser.getUsername());
        session.setAttribute("user_picture", loggedUser.getProfilePicture());
        session.setAttribute("user_role", loggedUser.getRole());

        return "redirect:/home";
    }
}
