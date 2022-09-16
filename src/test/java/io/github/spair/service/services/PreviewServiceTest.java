package io.github.spair.service.services;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.example.repository.entities.Article;
import com.spring.example.repository.entities.Preview;
import com.spring.example.service.services.ArticleService;
import com.spring.example.service.services.PreviewService;
import com.spring.example.service.services.impl.PreviewServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PreviewServiceTest {

    private final PreviewServiceTestHelper helper = new PreviewServiceTestHelper();
    private final List<Preview> checkingPreviewList = new ArrayList<>();
    private final List<Article> articleList = new ArrayList<>();
    private static final int START = 0;
    private static final int LIMIT = 2;
    private static final int TOTAL = 10;

    @TestConfiguration
    static class PreviewServiceTestConfig {
        @Bean
        public PreviewService previewService() {
            return new PreviewServiceImpl();
        }
    }

    @Autowired
    private PreviewService previewService;

    @MockBean
    private ArticleService articleService;

   

    @Test
    public void testGetLastInRange() {
        List<Preview> previewList = previewService.getLastInRange(START, LIMIT);
        List<Preview> checkedList = Lists.newArrayList(checkingPreviewList.get(TOTAL - 1), checkingPreviewList.get(TOTAL - 2));

        assertEquals(checkedList, previewList);
    }

    @Test
    public void testGetAll() {
        assertEquals(checkingPreviewList, previewService.getAll());
    }
}
