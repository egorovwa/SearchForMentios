package com.example.search_for_mentions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true,length = 50)
    private String name;
    @OneToMany()
    private List<RequestWord> words;

    public Question(String name, List<RequestWord> words) {
        this.name = name;
        this.words = words;
    }
}
