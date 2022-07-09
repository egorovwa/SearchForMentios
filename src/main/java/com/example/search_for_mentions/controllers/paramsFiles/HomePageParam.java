package com.example.search_for_mentions.controllers.paramsFiles;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Data
public class HomePageParam {
    private List<String> q;
    private LocalDate from;
    private String sortBy;
    private String apiKey;
    // TODO: 07.07.2022 where find news
}
