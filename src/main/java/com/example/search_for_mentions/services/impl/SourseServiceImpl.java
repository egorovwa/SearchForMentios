package com.example.search_for_mentions.services.impl;

import com.example.search_for_mentions.model.NewsSource;
import com.example.search_for_mentions.services.SourseService;
import com.example.search_for_mentions.storage.SourceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SourseServiceImpl implements SourseService {
    private final SourceDao sourceDao;

    @Override
    public List<NewsSource> getAll() {
        return sourceDao.findAll();
    }

    @Override
    public NewsSource findByName(String name) {
        return sourceDao.findByName(name).orElseThrow(() -> new NoSuchElementException("Sours not found"));
    }

    @Override
    public NewsSource update(NewsSource newsSource) {
        if (sourceDao.findByName(newsSource.getName()).isPresent()) {
            return sourceDao.save(newsSource);
        } else {
            throw new NoSuchElementException("Sours not found");
        }
    }
}
