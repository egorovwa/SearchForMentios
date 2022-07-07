package com.example.search_for_mentions.services.impl;

import com.example.search_for_mentions.ClientGoogle.FeingGoogleNews;
import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.ClientGoogle.model.Example;
import com.example.search_for_mentions.ClientGoogle.model.Source;

import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.model.NewsSource;
import com.example.search_for_mentions.controllers.paramsFiles.HomePageParam;
import com.example.search_for_mentions.services.FindNewsService;
import com.example.search_for_mentions.storage.NewsDao;
import com.example.search_for_mentions.storage.SourceDao;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindNewsServiceImpl implements FindNewsService {
    final private FeingGoogleNews feingGoogleNews;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;
    private final NewsDao newsDao;
    private final SourceDao sourceDao;


    @Override
    public List<String> getNewsList(HomePageParam homePageParam) {
        String q = homePageParam.getQ();
        LocalDate from = homePageParam.getFrom();
        String sortBy = homePageParam.getSortBy();
        String apiKey = GoogleNewsRequestsString.apiKey; // TODO: 07.07.2022 needclient Selenium
        String toClientFrom = dateFormat.format(from);
        Example example = feingGoogleNews.getArticle(q, toClientFrom, sortBy, apiKey);

        List<String> newsList = new ArrayList<>();
        example.getArticles().forEach(r -> {
            if (newsDao.findByUrl(r.getUrl()).isEmpty()) {
                Source source = r.getSource(); // TODO: 07.07.2022 create sours по людски
                News news = new News(r.getAuthor(), r.getTitle(), r.getDescription(), r.getUrl(),
                        r.getUrlToImage(), r.getPublishedAt(), r.getContent()); // TODO: 07.07.2022 delete content ибо бесполезно
                NewsSource newsSource = checkOrSaveSourse(source.getName())
                        .orElse(sourceDao.save(new NewsSource(source.getName(), source.getId())));
                newsSource.getNewsList().add(news);
                news.setNewsSource(newsSource);
                newsList.add(news.getTitle());
                newsDao.save(news);
            }


        });
        return newsList;
    }

    private Optional<NewsSource> checkOrSaveSourse(String sourceName) {
        return sourceDao.findByName(sourceName);
    }

}
