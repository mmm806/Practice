package org.example.csr_practice.controller;

import org.example.csr_practice.dto.UserDto;
import org.example.csr_practice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String saveUser(@RequestBody UserDto user) {
        return userService.saveUser(user).userName();
    }

    @GetMapping("/{name}")
    public UserDto getUserByName(@PathVariable String name) {
        Optional<UserDto> user = userService.getUserByName(name);
        return user.orElse(null);
    }
}
