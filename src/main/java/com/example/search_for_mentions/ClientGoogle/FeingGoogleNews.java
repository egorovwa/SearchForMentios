package com.example.search_for_mentions.ClientGoogle;

import com.example.search_for_mentions.ClientGoogle.model.Article;
import com.example.search_for_mentions.ClientGoogle.model.Example;
import com.example.search_for_mentions.ClientGoogle.model.Source;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(value = "googleClient",url = "https://newsapi.org/")
public interface FeingGoogleNews {

    @GetMapping(path = "v2/everything?q=Барнаул&from=2022-06-05&sortBy=publishedAt&apiKey=f28eaaa0b4254a589190a5132d59e2ca",
    consumes = "application/json")
    Example getArticle();
}
