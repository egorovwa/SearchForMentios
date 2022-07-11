package com.example.search_for_mentions.controllers.rest;

import com.example.search_for_mentions.model.Question;
import com.example.search_for_mentions.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
@PostMapping
   public Question addQuestion(@RequestBody Question question){
    return questionService.addQuestion(question);
}
@GetMapping("/{name}")
    public Question getQuestion(@PathVariable String name){
    return questionService.getQuestion(name);
}
@PutMapping
    public Question addWord(@PathParam("q") String questionName, @PathParam("word") String word,
                            @PathParam("language") String language){
   return questionService.addWordToQuestion(questionName,word,language);
}
}
