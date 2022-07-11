package com.example.search_for_mentions.controllers.rest;

import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.model.PositiveStatus;
import com.example.search_for_mentions.services.FindNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/news")
public class GoogleNewsController {
    private final FindNewsService findNewsService;

    @GetMapping
    public List<News> findAllNews(){
       return findNewsService.getAllNews();
    }
    @GetMapping("/status")
    private List<News> findNews(@RequestParam PositiveStatus positiveStatus){
return findNewsService.findByStatus(positiveStatus);
    }

    @PutMapping
    public News updateNews(@RequestBody News news){
        return findNewsService.update(news);
    }
    @PutMapping("/status/{id}")
    public News selectNewsStatus(@RequestParam String status, @PathParam("id") Integer id){ // TODO: 11.07.2022 брать ибо бессмысленно
       return findNewsService.selectNewsStatus(id,status);
    }
}


