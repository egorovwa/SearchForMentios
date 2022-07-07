package com.example.search_for_mentions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    NewsSource newsSource;
    String author;
    @Column(length = 500)
    String title;
    @Column(length = 2000)
    String description;
    @Column(length = 500,unique = true)  // TODO: 07.07.2022 посчитать изменить
    String url;
    @Column(length = 1500)  // TODO: 07.07.2022 посчитать изменить
    String urlToImage;
    String publishedAt;
    String content;
    PositiveStatus positiveStatus;
    @ManyToOne
    Category category;


    public News(String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}
