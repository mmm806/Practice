package org.example.crud_api_practice.repository;

import org.example.crud_api_practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
