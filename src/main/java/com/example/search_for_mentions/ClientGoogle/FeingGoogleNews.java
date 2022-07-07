package com.example.search_for_mentions.ClientGoogle;

import com.example.search_for_mentions.ClientGoogle.model.Article;
import com.example.search_for_mentions.ClientGoogle.model.Example;
import com.example.search_for_mentions.ClientGoogle.model.Source;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@Component
@FeignClient(value = "googleClient",url = "https://newsapi.org/")
public interface FeingGoogleNews {

    @GetMapping(path = "v2/everything",
    consumes = "application/json")
    Example getArticle(@RequestParam String q, @RequestParam String from, @RequestParam String sortBy,
                       @RequestParam String apiKey);
}
