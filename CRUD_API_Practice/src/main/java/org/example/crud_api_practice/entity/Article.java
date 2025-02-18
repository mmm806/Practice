package org.example.crud_api_practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
