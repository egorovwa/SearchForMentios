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
@RequestMapping("/search")
public class GoogleNewsController {
    private final FindNewsService findNewsService;
    @ModelAttribute(name = "homepage")
    public HomePageParam param(){
        return new HomePageParam();
    }

    @GetMapping
    public List<String> searchWithGoogle(@RequestBody HomePageParam homePageParam) {
       return findNewsService.getNewsList(homePageParam);
    }
    @GetMapping("/develop")
    public HomePageParam sendJsonHPP(){
        HomePageParam homePageParam = new HomePageParam();
        homePageParam.setApiKey(GoogleNewsRequestsString.apiKey);
        homePageParam.setQ("Путин");
        homePageParam.setFrom(LocalDate.now());
        return homePageParam;
    }
}

