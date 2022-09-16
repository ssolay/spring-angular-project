package com.spring.example.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.repository.entities.Article;
import com.spring.example.repository.entities.Preview;
import com.spring.example.service.services.ArticleService;
import com.spring.example.service.services.PreviewService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreviewServiceImpl implements PreviewService {

    @Autowired
    private ArticleService articleService;

    @Override
    public List<Preview> getLastInRange(int start, int limit) {
        List<Article> articleList = articleService.getLastInRangeWithoutText(start, limit);
        List<Preview> previewList = new ArrayList<>();

        articleList.forEach(article -> previewList.add(
                new Preview(article.getId(), article.getTitle(), article.getImageLink(), article.getPreviewText())
        ));

        return previewList;
    }

    @Override
    public List<Preview> getAll() {
        List<Article> articleList = articleService.getAllWithoutText();
        List<Preview> previewList = new ArrayList<>();

        articleList.forEach(article -> previewList.add(
                new Preview(article.getId(), article.getTitle(), article.getImageLink(), article.getPreviewText())
        ));

        return previewList;
    }
}
