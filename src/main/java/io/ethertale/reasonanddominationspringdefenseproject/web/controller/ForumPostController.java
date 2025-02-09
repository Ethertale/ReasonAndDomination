package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.service.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forum/posts")
public class ForumPostController {

    ForumPostService forumPostService;

    @Autowired
    public ForumPostController(ForumPostService forumPostService) {
        this.forumPostService = forumPostService;
    }

    @GetMapping
    public ModelAndView posting(){
        ModelAndView modelAndView = new ModelAndView("forumPost");
        modelAndView.setViewName("forumPost");
        return modelAndView;
    }

    @GetMapping("/{slug}")
    public ModelAndView getPost(@PathVariable String slug){
        ModelAndView modelAndView = new ModelAndView("forumPost");
        modelAndView.addObject("specPost", forumPostService.getForumPostBySlug(slug));
        modelAndView.setViewName("forumPost");
        return modelAndView;
    }

}
