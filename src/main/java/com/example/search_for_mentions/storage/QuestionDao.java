package com.example.search_for_mentions.storage;

import com.example.search_for_mentions.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    Optional<Question> findByName(String name);
}
