package com.example.search_for_mentions.services.impl;

import com.example.search_for_mentions.ClientGoogle.FeingGoogleNews;
import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.ClientGoogle.model.Example;
import com.example.search_for_mentions.ClientGoogle.model.Source;

import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.model.NewsSource;
import com.example.search_for_mentions.controllers.paramsFiles.HomePageParam;
import com.example.search_for_mentions.model.Question;
import com.example.search_for_mentions.model.RequestWord;
import com.example.search_for_mentions.services.FindNewsService;
import com.example.search_for_mentions.storage.NewsDao;
import com.example.search_for_mentions.storage.SourceDao;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindNewsServiceImpl implements FindNewsService {
    final private FeingGoogleNews feingGoogleNews;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;
    private final NewsDao newsDao;
    private final SourceDao sourceDao;


    private List<String> getNewsList(RequestWord q, LocalDate from, String sortBy, String apiKey) {
        String toClientFrom = dateFormat.format(from);
        Example example = feingGoogleNews.getArticle(q.getWord(), toClientFrom, sortBy, apiKey);
        log.info("Полученно {} упоминаний", example.getArticles().size());
        List<String> newsList = new ArrayList<>();
        example.getArticles().forEach(r -> {
            if (newsDao.findByUrl(r.getUrl()).isEmpty()) {
                Source source = r.getSource(); // TODO: 07.07.2022 create sours по людски
                News news = new News(r.getAuthor(), r.getTitle(), r.getDescription(), r.getUrl(),
                        r.getUrlToImage(), r.getPublishedAt(), r.getContent()); // TODO: 07.07.2022 delete content ибо бесполезно
                NewsSource newsSource = checkOrSaveSourse(source.getName())
                        .orElse(sourceDao.save(new NewsSource(source.getName(), source.getId())));
                newsSource.getNewsList().add(news);
                news.setNewsSource(newsSource.getName());
                news.setWord(q);
                newsList.add(news.getTitle());
                newsDao.save(news);
            }


        });
        return newsList;
    }

    private Optional<NewsSource> checkOrSaveSourse(String sourceName) {
        return sourceDao.findByName(sourceName);
    }

    @Override
    public List<String> findNews(HomePageParam homePageParam) {
        Question q = homePageParam.getQ();
        LocalDate from = homePageParam.getFrom();
        String sortBy = homePageParam.getSortBy();
        String apiKey = GoogleNewsRequestsString.apiKey; // TODO: 07.07.2022 needclient Selenium
        q.getWords().forEach(r -> getNewsList(r, from, sortBy, apiKey));
        return null;
    }

    @Override
    public List<News> getAllNews() {
        return newsDao.findAll();
    }

    @Override
    public News update(News news) {
        if (newsDao.findByUrl(news.getUrl()).isPresent()) {
            return newsDao.save(news);
        } else {
            throw new NoSuchElementException(news.getUrl());
        }
    }
}
