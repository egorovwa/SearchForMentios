package com.example.search_for_mentions.controllers;

import com.example.search_for_mentions.ClientGoogle.FeingGoogleNews;
import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.ClientGoogle.model.Article;
import com.example.search_for_mentions.ClientGoogle.model.Example;
import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.services.FindNewsService;
import lombok.RequiredArgsConstructor;
import com.example.search_for_mentions.ClientGoogle.model.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GoogleNewsController {
    private final FindNewsService findNewsService;

    @GetMapping("/")
    List<News> getTestReguest(){
      return  findNewsService.getNewsWithQAndFrom();
    }
}
