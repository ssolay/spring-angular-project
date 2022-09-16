package io.github.spair.service.services;

import com.spring.example.repository.entities.Article;
import com.spring.example.repository.entities.Preview;

final class PreviewServiceTestHelper {


    Preview getPreviewTemplateWithId(Long id) {
        return new Preview(id, "title", "imageLink", "preview");
    }
}
