package com.example.search_for_mentions.services;

import com.example.search_for_mentions.model.NewsSource;

import java.util.List;
import java.util.Set;

public interface SourseService {
    List<NewsSource> getAll();
    NewsSource findByName(String name);
    NewsSource update(NewsSource newsSource);
}
