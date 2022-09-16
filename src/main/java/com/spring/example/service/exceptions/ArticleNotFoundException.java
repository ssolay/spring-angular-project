package com.spring.example.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleNotFoundException extends RuntimeException {

    private Long articleId;

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	public ArticleNotFoundException(long articleId)
	{
		this.articleId = articleId;
	}
}
