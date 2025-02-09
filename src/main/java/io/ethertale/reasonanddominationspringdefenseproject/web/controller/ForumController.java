package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.service.ForumPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;

@Controller
@RequestMapping("/forum")
public class ForumController {

    ForumPostService forumPostService;

    public ForumController(ForumPostService forumPostService) {
        this.forumPostService = forumPostService;
    }

    @GetMapping
    public ModelAndView forum() {
        ModelAndView modelAndView = new ModelAndView("forum");
        modelAndView.addObject("forumPosts", forumPostService.getAllForumPostsReversed());
        modelAndView.setViewName("forum");
        return modelAndView;
    }
}
