package org.example.crud_api_practice.controller;

import org.example.crud_api_practice.dto.UserDTO;
import org.example.crud_api_practice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return new UserDTO(userService.getUserById(userId));
    }

    @PostMapping
    public UserDTO createUser(@RequestParam String username) {
        return new UserDTO(userService.createUser(username));
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestParam String username) {
        return new UserDTO(userService.updateUser(userId, username));
    }

    @DeleteMapping("/{userId}")
    public void delteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
