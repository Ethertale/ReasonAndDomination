package io.ethertale.reasonanddominationspringdefenseproject.guides.service;

import io.ethertale.reasonanddominationspringdefenseproject.guides.model.GuidePost;
import io.ethertale.reasonanddominationspringdefenseproject.guides.model.PostType;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface GuidePostService {
    GuidePost createGuidePost(String title, String content, PostType type);
    List<GuidePost> getGuidePostsByType(PostType type);
}
