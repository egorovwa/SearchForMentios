package com.example.search_for_mentions.controllers.rest;

import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.controllers.paramsFiles.HomePageParam;
import com.example.search_for_mentions.model.Question;
import com.example.search_for_mentions.model.RequestWord;
import com.example.search_for_mentions.services.FindNewsService;
import com.example.search_for_mentions.services.QuestionService;
import com.example.search_for_mentions.services.SourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class DevelopAndTestController {
    private final FindNewsService findNewsService;
    private final SourseService sourseService;
    private final QuestionService questionService;
    @GetMapping("/param")
    public HomePageParam sendJsonHPP(){
        HomePageParam homePageParam = new HomePageParam();
        Question question = questionService.getQuestion("Putin");

        homePageParam.setApiKey(GoogleNewsRequestsString.apiKey);
        homePageParam.setQ(question);
        homePageParam.setFrom(LocalDate.now());
        return homePageParam;
    }
    @GetMapping("/search")
    public List<String> searchWithGoogle(@RequestBody HomePageParam homePageParam) {
        return findNewsService.findNews(homePageParam);
    }
    @PostMapping("/question")
    Question createPutinRuEnQuestion(){
        RequestWord ru = new RequestWord("Путин","RU");
        RequestWord en = new RequestWord("Putin","EN");
        Question question = new Question("Putin",List.of(ru,en));
       return questionService.addQuestion(question);
    }
}
