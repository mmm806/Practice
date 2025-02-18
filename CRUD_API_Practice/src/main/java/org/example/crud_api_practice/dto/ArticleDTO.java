package org.example.crud_api_practice.dto;

import org.example.crud_api_practice.entity.Article;

public class ArticleDTO {
    private Long id;
    private String title;
    private String content;

    public ArticleDTO(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }

    public Long getId() { return id; }
    public String getTitle() { return title;}
    public String getContent() {return content;}
}
