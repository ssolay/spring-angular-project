package com.spring.example.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Preview {

    private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private String title;
    private String imageLink;
    private String text;
    
    public Preview(Long id, String title, String imageLink, String text)
    {
    	this.id = id;
    	this.title = title;
    	this.imageLink = imageLink;
    	this.text = text;
    }
    
}
