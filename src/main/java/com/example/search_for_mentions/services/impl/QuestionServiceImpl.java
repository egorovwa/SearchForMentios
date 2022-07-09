package com.example.search_for_mentions.services.impl;

import com.example.search_for_mentions.exceptions.NotFoundException;
import com.example.search_for_mentions.model.Question;
import com.example.search_for_mentions.model.RequestWord;
import com.example.search_for_mentions.services.QuestionService;
import com.example.search_for_mentions.storage.QuestionDao;
import com.example.search_for_mentions.storage.RequestWordDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final RequestWordDao requestWordDao;

    @Override
    public Question addQuestion(Question question) {
        question.getWords().forEach(w -> {
            if (requestWordDao.findByWord(w.getWord()).isEmpty()) {
                requestWordDao.save(w);
            }
        });
        questionDao.save(question); // TODO: 09.07.2022 проверка на уникальность
        return question;
    }

    @Override
    public Question getQuestion(String name) {
        return questionDao.findByName(name).orElseThrow(() -> new NotFoundException("не найдено")); // TODO: 09.07.2022  сделать по людски
    }

    @Override
    public Question addWordToQuestion(String name, String word, String language) {
        Question question = questionDao.findByName(name).orElseThrow(() -> new NotFoundException("не найдено"));
        RequestWord requestWord = requestWordDao.findByWord(word).orElseGet(() -> {
            RequestWord rw = new RequestWord(word, language);
            requestWordDao.save(rw);
            return rw;
        });
        return null;
    }
}
