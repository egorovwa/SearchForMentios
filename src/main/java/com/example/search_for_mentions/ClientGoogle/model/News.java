package com.example.search_for_mentions.ClientGoogle.model;

import lombok.Data;

@Data
public class News {
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;
    String content;
}
