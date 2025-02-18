package org.example.crud_api_practice.dto;

import org.example.crud_api_practice.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String username;
    private List<ArticleDTO> articles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.articles = user.getArticles().stream()
                .map(ArticleDTO::new)
                .collect(Collectors.toList());
    }

    // Getter 추가
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public List<ArticleDTO> getArticles() { return articles; }
}
