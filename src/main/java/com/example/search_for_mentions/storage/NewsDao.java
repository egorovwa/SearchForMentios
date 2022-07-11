package com.example.search_for_mentions.storage;

import com.example.search_for_mentions.model.News;
import com.example.search_for_mentions.model.PositiveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsDao extends JpaRepository<News,Integer>{
    Optional<News> findByUrl(String url);
    List<News> findAllByPositiveStatus(PositiveStatus positiveStatus);

}
