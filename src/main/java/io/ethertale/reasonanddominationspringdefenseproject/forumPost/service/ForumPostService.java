package io.ethertale.reasonanddominationspringdefenseproject.forumPost.service;

import io.ethertale.reasonanddominationspringdefenseproject.forumPost.model.ForumPost;

import java.util.List;

public interface ForumPostService {
    List<ForumPost> getAllForumPosts();
    ForumPost createForumPost(String title, String content);
}
