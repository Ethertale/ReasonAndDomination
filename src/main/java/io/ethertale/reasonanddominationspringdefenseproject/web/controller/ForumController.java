package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.model.ForumPost;
import io.ethertale.reasonanddominationspringdefenseproject.forumPost.repo.ForumPostRepo;
import io.ethertale.reasonanddominationspringdefenseproject.forumPost.service.ForumPostService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ForumPostForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;

@Controller
@RequestMapping("/forum")
public class ForumController {

    ForumPostService forumPostService;
    ForumPostRepo forumPostRepo;

    public ForumController(ForumPostService forumPostService, ForumPostRepo forumPostRepo) {
        this.forumPostService = forumPostService;
        this.forumPostRepo = forumPostRepo;
    }

    @GetMapping
    public ModelAndView forum() {
        ModelAndView modelAndView = new ModelAndView("forum");
        modelAndView.addObject("forumPosts", forumPostRepo.findAll().stream().sorted(Comparator.comparing(ForumPost::getCreatedOn).reversed()));
        modelAndView.setViewName("forum");
        return modelAndView;
    }
}
