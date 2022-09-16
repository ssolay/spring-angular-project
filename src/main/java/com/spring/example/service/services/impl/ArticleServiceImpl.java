package com.spring.example.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.repository.entities.Article;
import com.spring.example.repository.repositories.ArticleRepository;
import com.spring.example.service.exceptions.ArticleNotFoundException;
import com.spring.example.service.services.ArticleService;
import com.spring.example.service.services.SequenceService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public Article create(Article article) {
        article.setId(sequenceService.getNextSequence(Article.getSequenceName()));
        return articleRepository.save(article);
    }

    @Override
    public Article getById(Long id) throws ArticleNotFoundException {
        Article article = articleRepository.findOne(id);

        if (article == null) {
            throw new ArticleNotFoundException(id);
        }

        return article;
    }

    @Override
    public void update(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.delete(id);
    }

    @Override
    public List<Article> getLastInRangeWithoutText(int start, int limit) {
        return articleRepository.getLastInRangeWithoutText(start, limit);
    }

    @Override
    public List<Article> getAllWithoutText() {
        return articleRepository.findAllWithoutText();
    }
}
