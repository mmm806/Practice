package org.example.crud_api_practice.service;

import org.example.crud_api_practice.entity.Article;
import org.example.crud_api_practice.entity.User;
import org.example.crud_api_practice.repository.ArticleRepository;
import org.example.crud_api_practice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }

    public Article createArticle(Long userId, String title, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return articleRepository.save(new Article(title, content, user));
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    public List<Article> getArticleByUser(Long userId) {
        return articleRepository.findByUserId(userId);
    }

    public Article getArticleByUserAndId(Long userId, Long articleId) {
        return articleRepository.findById(articleId)
                .filter(article -> article.getUser().getId().equals(userId))
                .orElseThrow(() -> new IllegalArgumentException("Article not found or does not belong to the user"));
    }

}
