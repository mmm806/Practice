package org.example.variousrequestdatapractice.repository;

import org.example.variousrequestdatapractice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCaseAndPriceBetween(String name, double minPrice, double maxPrice);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
