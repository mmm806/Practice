package org.example.mvcpractice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void updateEmail(String newEmail) {
        if (!newEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = newEmail;
    }

}
