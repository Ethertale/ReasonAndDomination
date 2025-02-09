package io.ethertale.reasonanddominationspringdefenseproject.forumPost.service;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.model.ForumPost;
import io.ethertale.reasonanddominationspringdefenseproject.forumPost.repo.ForumPostRepo;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.ForumPostForm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class ForumPostServiceImpl implements ForumPostService {

    ForumPostRepo forumPostRepo;

    public ForumPostServiceImpl(ForumPostRepo forumPostRepo) {
        this.forumPostRepo = forumPostRepo;
    }

    @Override
    public List<ForumPost> getAllForumPosts() {
        return forumPostRepo.findAll();
    }

    @Override
    public ForumPost createForumPost(String title, String content) {
        ForumPost forumPost = ForumPost.builder()
                .title(title)
                .content(content)
                .createdOn(LocalDateTime.now())
                .build();

        forumPost.setSlug(title);

        return forumPostRepo.save(forumPost);
    }

    @Override
    public List<ForumPost> findLastFive() {
        return forumPostRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(ForumPost::getCreatedOn))
                .toList()
                .subList(forumPostRepo.findAll().size() - 5, forumPostRepo.findAll().size())
                .stream().sorted(Comparator.comparing(ForumPost::getCreatedOn).reversed()).toList();
    }
}
