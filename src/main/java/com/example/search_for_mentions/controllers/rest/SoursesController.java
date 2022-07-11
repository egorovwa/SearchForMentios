package com.example.search_for_mentions.controllers.rest;

import com.example.search_for_mentions.model.NewsSource;
import com.example.search_for_mentions.services.FindNewsService;
import com.example.search_for_mentions.services.SourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sourses")
@RequiredArgsConstructor
public class SoursesController {
    private final SourseService sourseService;
    @GetMapping
    public List<NewsSource> getAll(){
        return sourseService.getAll();
    }
    @GetMapping("/{name}")
    public NewsSource findByName(@PathVariable String name){
        return sourseService.findByName(name);
    }

}
