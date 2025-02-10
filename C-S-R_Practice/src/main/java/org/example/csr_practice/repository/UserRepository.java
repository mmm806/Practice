package org.example.csr_practice.repository;

import org.example.csr_practice.dto.UserDto;

import java.util.Optional;

public interface UserRepository {
    void saveUser(UserDto userDto);
    Optional<UserDto> getUser(String userName);
}
