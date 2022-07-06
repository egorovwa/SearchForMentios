package com.example.search_for_mentions.ClientGoogle.model;

import lombok.Data;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Data
public class Example {

     String status;
     Integer totalResults;
     List<Article> articles = null;

}