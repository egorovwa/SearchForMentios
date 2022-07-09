package com.example.search_for_mentions.controllers;

import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.controllers.paramsFiles.HomePageParam;
import com.example.search_for_mentions.services.FindNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GoogleNewsController {
    private final FindNewsService findNewsService;
    @ModelAttribute(name = "homepage")
    public HomePageParam param(){
        return new HomePageParam();
    }

    @GetMapping("/test/search")
    public List<String> searchWithGoogle(@RequestBody HomePageParam homePageParam) {
       return findNewsService.findNews(homePageParam);
    }
    @GetMapping("/test")
    public HomePageParam sendJsonHPP(){
        HomePageParam homePageParam = new HomePageParam();
        homePageParam.setApiKey(GoogleNewsRequestsString.apiKey);
        homePageParam.setQ(List.of("Путин","Putin"));
        homePageParam.setFrom(LocalDate.now());
        return homePageParam;
    }
    @GetMapping("/news")
    public List<News> findNews(){
       return findNewsService.getAllNews();
    }
    @PutMapping("/news")
    public News updateNews(@RequestBody News news){
        return findNewsService.update(news);
    }
}

