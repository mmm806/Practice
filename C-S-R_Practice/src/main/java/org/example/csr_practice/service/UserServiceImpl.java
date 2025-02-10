package org.example.csr_practice.service;

import org.example.csr_practice.dto.UserDto;
import org.example.csr_practice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        userRepository.saveUser(userDto);
        return userDto;
    }

    @Override
    public Optional<UserDto> getUserByName(String name) {
        return userRepository.getUser(name);
    }
}
