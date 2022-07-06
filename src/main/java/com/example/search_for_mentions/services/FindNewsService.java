package com.example.search_for_mentions.services;

import com.example.search_for_mentions.model.News;

import java.util.List;

public interface FindNewsService {
    List<News> getNewsWithQAndFrom();
}
