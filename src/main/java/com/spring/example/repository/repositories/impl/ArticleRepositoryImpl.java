package com.spring.example.repository.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.example.repository.entities.Article;
import com.spring.example.repository.repositories.ArticleRepositoryOperations;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepositoryOperations {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Article> getLastInRangeWithoutText(int start, int limit) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        query.fields().exclude("text");
        query.skip(start);
        query.limit(limit);
        return mongoOperations.find(query, Article.class);
    }
}
