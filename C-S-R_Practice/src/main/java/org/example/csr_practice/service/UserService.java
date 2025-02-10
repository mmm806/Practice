package org.example.csr_practice.service;

import org.example.csr_practice.dto.UserDto;

import java.util.Optional;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    Optional<UserDto> getUserByName(String name);
}
