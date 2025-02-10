package org.example.csr_practice.repository;

import org.example.csr_practice.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Map<String, UserDto> users = new HashMap<>();

    @Override
    public void saveUser(UserDto userDto) {
        users.put(userDto.userName(), userDto);
    }

    @Override
    public Optional<UserDto> getUser(String userName) {
        return Optional.ofNullable(users.get(userName));
    }
}
