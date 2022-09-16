package io.github.spair.repository.repositories;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.example.repository.entities.Article;
import com.spring.example.repository.repositories.ArticleRepository;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ArticleRepositoryTest {

    private static final Long FIRST_ID = 1L;
    private static final Long LAST_ID  = 10L;
    private final ArticleRepositoryTestHelper helper = new ArticleRepositoryTestHelper();

    @Autowired
    private ArticleRepository articleRepository;

    

    @Test
    public void testFindAllWithoutText() {
        List<Article> articleList = articleRepository.findAllWithoutText();

        assertTrue(articleList.size() > 0);
        articleList.forEach(article -> assertNull(article.getText()));
    }
}
