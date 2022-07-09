package com.example.search_for_mentions.storage;

import com.example.search_for_mentions.model.RequestWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestWordDao extends JpaRepository<RequestWord,String> {
    Optional<RequestWord> findByWord(String word);
}
