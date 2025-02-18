package org.example.crud_api_practice.service;

import org.example.crud_api_practice.entity.User;
import org.example.crud_api_practice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User createUser(String username) {
        return userRepository.save(new User(username));
    }

    public User updateUser(Long userId, String newUsername) {
        User user = getUserById(userId);
        user.setUsername(newUsername);
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
