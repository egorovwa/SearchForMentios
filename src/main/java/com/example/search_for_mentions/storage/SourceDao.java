package com.example.search_for_mentions.storage;

import com.example.search_for_mentions.model.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SourceDao extends JpaRepository<NewsSource,Integer> {
    Optional<NewsSource> findByName(String name);
}
