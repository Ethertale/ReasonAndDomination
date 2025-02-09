package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.guides.service.GuidePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/guides/posts")
public class GuidesPostController {

    GuidePostService guidePostService;

    @Autowired
    public GuidesPostController(GuidePostService guidePostService) {
        this.guidePostService = guidePostService;
    }

    @GetMapping
    public ModelAndView guiding(){
        ModelAndView modelAndView = new ModelAndView("guidesPost");
        modelAndView.setViewName("guidesPost");
        return modelAndView;
    }

    @GetMapping("/{slug}")
    public ModelAndView getGuidePost(@PathVariable String slug){
        ModelAndView modelAndView = new ModelAndView("guidesPost");
        modelAndView.addObject("specPost", guidePostService.getGuidePostsBySlug(slug));
        modelAndView.setViewName("guidesPost");
        return modelAndView;
    }
}
