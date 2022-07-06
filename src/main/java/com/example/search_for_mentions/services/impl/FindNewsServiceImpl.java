package com.example.search_for_mentions.services.impl;

import com.example.search_for_mentions.ClientGoogle.FeingGoogleNews;
import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.ClientGoogle.model.Example;
import com.example.search_for_mentions.ClientGoogle.model.Source;
import com.example.search_for_mentions.controllers.GoogleNewsController;
import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.services.FindNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class FindNewsServiceImpl implements FindNewsService {
final private FeingGoogleNews feingGoogleNews;



    @Override
    public List<News> getNewsWithQAndFrom() {
        String q = "Barnaul";
        String from = Date.from(Instant.now()).toString();
        String sortBy = "publishedAt";
        String apiKey = GoogleNewsRequestsString.apiKey;
       Example example = feingGoogleNews.getArticle(q,from,sortBy,apiKey);

       List<News>  newsList = new ArrayList<>();
       example.getArticles().forEach(r->{
           Source source = r.getSource(); // TODO: 06.07.2022 сохранять в базу
           News news = new News(r.getAuthor(),r.getTitle(),r.getDescription(),r.getUrl(),
                   r.getUrlToImage(),r.getPublishedAt(),r.getContent());
           newsList.add(news);

       });
        return newsList;
    }
}
