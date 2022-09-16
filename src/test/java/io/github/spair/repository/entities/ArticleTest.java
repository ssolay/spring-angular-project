package io.github.spair.repository.entities;

import org.junit.Assert;
import org.junit.Test;

import com.spring.example.repository.entities.Article;

public class ArticleTest {

    @Test
    public void testGetSequenceName() {
        Assert.assertEquals("articles", Article.getSequenceName());
    }
}
