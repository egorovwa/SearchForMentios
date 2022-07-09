package com.example.search_for_mentions;

import com.example.search_for_mentions.ClientGoogle.GoogleNewsRequestsString;
import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.controllers.paramsFiles.HomePageParam;
import com.example.search_for_mentions.services.FindNewsService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SearchForMentionsApplicationTests {
    private final FindNewsService findNewsService;

    @Test
    void test1_findFromNowBarnaul() {
        HomePageParam pageParam = createTestParam();
       // List<News> newsList =findNewsService.findNews(pageParam);
       // assertTrue(newsList.size()>0);
    }

    private HomePageParam createTestParam() {
        HomePageParam pageParam = new HomePageParam();

        pageParam.setFrom(LocalDate.now());
        pageParam.setApiKey(GoogleNewsRequestsString.apiKey);
        return pageParam;
    }

    @Test
    void contextLoads() {
    }


}
