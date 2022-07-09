package com.example.search_for_mentions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    private String newsSource;
    private String author;
    @Column(length = 1000)
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(length = 500, unique = true)  // TODO: 07.07.2022 посчитать изменить
    private String url;
    @Column(length = 1500)  // TODO: 07.07.2022 посчитать изменить
    private String urlToImage;
    private String publishedAt;
    private String content;
    @Builder.Default
    PositiveStatus positiveStatus = PositiveStatus.UNDEFINDED;
    @ManyToOne
    private Category category;
    @ManyToOne
    private RequestWord word;


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
