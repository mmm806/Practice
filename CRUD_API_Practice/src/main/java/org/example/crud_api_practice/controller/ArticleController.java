package org.example.crud_api_practice.controller;

import org.example.crud_api_practice.dto.ArticleDTO;
import org.example.crud_api_practice.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDTO> getAllArticles() {
        return articleService.getAllArticles()
                .stream()
                .map(ArticleDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/articleId")
    public ArticleDTO getArticleById(@PathVariable Long articleId) {
        return new ArticleDTO(articleService.getArticleById(articleId));
    }

    @PostMapping
    public ArticleDTO createArticle(
            @RequestParam Long userId,
            @RequestParam String title,
            @RequestParam String content
    ) {
        return new ArticleDTO(articleService.createArticle(userId, title, content));
    }

    @DeleteMapping("/{articleId}")
    public void deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
    }
}
