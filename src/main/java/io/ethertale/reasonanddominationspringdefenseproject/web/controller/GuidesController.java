package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.guides.repo.GuidePostRepo;
import io.ethertale.reasonanddominationspringdefenseproject.guides.service.GuidePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/guides")
public class GuidesController {

    GuidePostRepo guidePostRepo;
    GuidePostService guidePostService;

    @Autowired
    public GuidesController(GuidePostRepo guidePostRepo, GuidePostService guidePostService) {
        this.guidePostRepo = guidePostRepo;
        this.guidePostService = guidePostService;
    }

    @GetMapping
    public ModelAndView guides(Model model) {
        ModelAndView modelAndView = new ModelAndView("guides");
        modelAndView.addObject("guidePosts", guidePostRepo.findAll());
        modelAndView.setViewName("guides");
        return modelAndView;
    }
}
