package com.example.search_for_mentions.ClientGoogle.model;

import lombok.Data;

@Data
public class Article {
     Source source;
     String author;
     String title;
     String description;
     String url;
     String urlToImage;
     String publishedAt;
     String content;

}