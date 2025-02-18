package org.example.crud_api_practice.repository;

import org.example.crud_api_practice.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository <Article, Long> {
    List<Article> findByUserId(Long userId);
}
