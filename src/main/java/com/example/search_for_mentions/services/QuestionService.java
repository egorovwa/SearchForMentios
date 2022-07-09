package com.example.search_for_mentions.services;

import com.example.search_for_mentions.model.Question;

public interface QuestionService {
Question addQuestion(Question question);
Question getQuestion(String name);
Question addWordToQuestion(String name,String word, String language);
}
