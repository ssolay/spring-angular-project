package io.github.spair.repository.repositories;

import java.util.List;

import com.spring.example.repository.entities.Article;

final class ArticleRepositoryTestHelper {


    List<Article> nullifyArticleText(List<Article> articleList) {
        articleList.forEach(article -> article.setText(null));
        return articleList;
    }
}
