package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.guides.model.PostType;
import io.ethertale.reasonanddominationspringdefenseproject.guides.service.GuidePostService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.GuidePostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/guides/create-guide")
public class GuidesCreatePostController {

    GuidePostService guidePostService;

    @Autowired
    public GuidesCreatePostController(GuidePostService guidePostService) {
        this.guidePostService = guidePostService;
    }

    @GetMapping
    public ModelAndView guide(){
        ModelAndView modelAndView = new ModelAndView("createGuidePost");
        modelAndView.addObject("guidePostForm", new GuidePostForm());
        modelAndView.addObject("postTypes", PostType.values());
        modelAndView.setViewName("createGuidePost");
        return modelAndView;
    }

    @PostMapping("/create")
    public String createGuidePost(@ModelAttribute GuidePostForm guidePostForm){
        guidePostService.createGuidePost(guidePostForm);

        return "redirect:/guides";
    }

}
