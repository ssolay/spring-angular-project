package com.spring.example.web.rest.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.example.service.exceptions.ArticleNotFoundException;

@ControllerAdvice
public class ArticleControllerAdvice {

    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error handleArticleNotFound(ArticleNotFoundException e) {
        return new Error(HttpStatus.NOT_FOUND.value(), "Article [" + e.getArticleId() + "] not found");

    }
}
