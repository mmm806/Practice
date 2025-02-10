package org.example.csr_practice.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository{

    @Override
    public String fetchData() {
        return "Hello from Repository!";
    }
}
