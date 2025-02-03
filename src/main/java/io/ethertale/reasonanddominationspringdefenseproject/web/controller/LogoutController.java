package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String getLogoutPage(HttpSession session) {

        session.invalidate();
        return "redirect:/login";
    }
}
