package com.example.search_for_mentions.storage;

import com.example.search_for_mentions.model.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SourceDao extends JpaRepository<NewsSource,Integer> {
    Optional<NewsSource> findByName(String name);
}
