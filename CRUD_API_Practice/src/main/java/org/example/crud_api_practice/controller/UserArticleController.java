package org.example.crud_api_practice.controller;

import org.example.crud_api_practice.dto.ArticleDTO;
import org.example.crud_api_practice.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/{userId}/articles")
public class UserArticleController {

    private final ArticleService articleService;

    public UserArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //특정 사용자의 모든 게시글 조회
    @GetMapping
    public List<ArticleDTO> getArticleeByUser(@PathVariable Long userId) {
        return articleService.getArticleByUser(userId)
                .stream()
                .map(ArticleDTO::new)
                .collect(Collectors.toList());
    }
    //특정 사용자의 특정 게시글 조회
    @GetMapping("/{articleId}")
    public ArticleDTO getArticleByUserAndId(@PathVariable Long userId, @PathVariable Long articleId) {
        return new ArticleDTO(articleService.getArticleByUserAndId(userId, articleId));
    }
    // 특정 사용자의 새 게시글 추가
    @PostMapping
    public ArticleDTO createArticle(
            @PathVariable Long userId,
            @RequestParam String title,
            @RequestParam String content
    ) {
        return new ArticleDTO(articleService.createArticle(userId, title,content));
    }

    //특정 사용자의 특정 게시글 삭제
    @DeleteMapping("/{articleId")
    public void deleteArticleByUser(@PathVariable Long userId, @PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
    }
}
