package com.example.search_for_mentions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
public class RequestWord {
    @Id
    String word;
    String language;


    public RequestWord(String word, String language) {
        this.word = word;
        this.language = language;
    }
}
