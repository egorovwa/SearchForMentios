package com.example.search_for_mentions.services;

import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.controllers.paramsFiles.HomePageParam;

import java.util.List;

public interface FindNewsService {
    List<String> findNews(HomePageParam homePageParam);

    List<News> getAllNews();

    News update(News news);

    // TODO: 07.07.2022 must return List or set
}
