package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.repo.ForumPostRepo;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ForumPostForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forum/posts")
public class ForumPostController {

    ForumPostRepo forumPostRepo;

    public ForumPostController(ForumPostRepo forumPostRepo) {
        this.forumPostRepo = forumPostRepo;
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
        modelAndView.addObject("specPost", forumPostRepo.findBySlug(slug));
        modelAndView.setViewName("forumPost");
        return modelAndView;
    }

}
