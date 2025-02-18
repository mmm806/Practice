package org.example.crud_api_practice.entity;

import jakarta.persistence.*;
import org.example.crud_api_practice.dto.ArticleDTO;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }
}
