package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

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

    GuidePostService guidePostService;

    @Autowired
    public GuidesController(GuidePostService guidePostService) {
        this.guidePostService = guidePostService;
    }

    @GetMapping
    public ModelAndView guides(Model model) {
        ModelAndView modelAndView = new ModelAndView("guides");
        modelAndView.addObject("guidePosts", guidePostService.getAllGuidePosts());
        modelAndView.setViewName("guides");
        return modelAndView;
    }
}
