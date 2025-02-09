package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.guides.model.GuidePost;
import io.ethertale.reasonanddominationspringdefenseproject.guides.model.PostType;
import io.ethertale.reasonanddominationspringdefenseproject.guides.repo.GuidePostRepo;
import io.ethertale.reasonanddominationspringdefenseproject.guides.service.GuidePostService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.GuidePostForm;
import jakarta.servlet.http.HttpSession;
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
    GuidePostRepo guidePostRepo;

    @Autowired
    public GuidesCreatePostController(GuidePostService guidePostService, GuidePostRepo guidePostRepo) {
        this.guidePostService = guidePostService;
        this.guidePostRepo = guidePostRepo;
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
    public String createGuidePost(@ModelAttribute GuidePostForm guidePostForm, HttpSession session){
        guidePostService.createGuidePost(guidePostForm.getTitle(), guidePostForm.getContent(), guidePostForm.getPostType());

        return "redirect:/guides";
    }

}
