package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.repo.ForumPostRepo;
import io.ethertale.reasonanddominationspringdefenseproject.forumPost.service.ForumPostService;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ForumPostForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forum/create-post")
public class ForumCreatePostController {

    ForumPostService forumPostService;
    ForumPostRepo forumPostRepo;

    public ForumCreatePostController(ForumPostService forumPostService, ForumPostRepo forumPostRepo) {
        this.forumPostService = forumPostService;
        this.forumPostRepo = forumPostRepo;
    }

    @GetMapping
    public ModelAndView post() {
        ModelAndView mav = new ModelAndView("createForumPost");
        mav.addObject("forumPostForm", new ForumPostForm());
        mav.setViewName("createForumPost");
        return mav;
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute ForumPostForm forumPostForm){
        forumPostService.createForumPost(forumPostForm.getTitle(), forumPostForm.getContent());

        return "redirect:/forum";
    }
}
