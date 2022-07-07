package com.example.search_for_mentions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class NewsSource {
    @Id
    @Column(unique = true)
    String name;
    String inId;
    String link;
    String contry;
    @OneToMany
    List<News> newsList = new ArrayList<>();
    @ManyToOne
    Category category;

    public NewsSource(String name, String inId) {
        this.name = name;
        this.inId = inId;
    }
}
