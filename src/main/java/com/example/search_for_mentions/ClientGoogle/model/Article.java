package com.example.search_for_mentions.ClientGoogle.model;

import lombok.Data;

@Data
public class Article {
    public Source source;
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;

}