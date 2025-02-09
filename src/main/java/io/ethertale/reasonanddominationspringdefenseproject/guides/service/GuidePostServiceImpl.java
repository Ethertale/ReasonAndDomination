package io.ethertale.reasonanddominationspringdefenseproject.guides.service;

import io.ethertale.reasonanddominationspringdefenseproject.guides.model.GuidePost;
import io.ethertale.reasonanddominationspringdefenseproject.guides.model.PostType;
import io.ethertale.reasonanddominationspringdefenseproject.guides.repo.GuidePostRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuidePostServiceImpl implements GuidePostService {

    HttpSession session;
    GuidePostRepo guidePostRepo;

    public GuidePostServiceImpl(HttpSession session, GuidePostRepo guidePostRepo) {
        this.session = session;
        this.guidePostRepo = guidePostRepo;
    }

    @Override
    public GuidePost createGuidePost(String title, String content, PostType type) {
        GuidePost guidePost = GuidePost.builder()
                .title(title)
                .content(content)
                .createdOn(LocalDateTime.now())
                .type(type)
                .author(session.getAttribute("user_name").toString())
                .build();

        guidePost.setSlug(title);

        return guidePostRepo.save(guidePost);
    }

    @Override
    public List<GuidePost> getGuidePostsByType(PostType type) {
        List<GuidePost> returnPosts = new ArrayList<>();
        guidePostRepo.findAll().stream().filter(post -> post.getType().equals(type)).forEach(
                returnPosts::add
        );
        return returnPosts
                .stream()
                .sorted(Comparator.comparing(GuidePost::getCreatedOn))
                .toList();
    }
}
