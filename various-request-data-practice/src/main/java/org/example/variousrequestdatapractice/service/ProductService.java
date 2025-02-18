package org.example.variousrequestdatapractice.service;

import org.example.variousrequestdatapractice.dto.ProductDTO;
import org.example.variousrequestdatapractice.model.Product;
import org.example.variousrequestdatapractice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .build();
        return productRepository.save(product);
    }

    public List<Product> searchProduct(String name, Double minPrice, Double maxPrice) {
        if(minPrice == null) minPrice = 0.0;
        if(maxPrice == null) maxPrice = Double.MAX_VALUE;
        if(name == null || name.isBlank()) {
            return productRepository.findByPriceBetween(minPrice, maxPrice);
        }
        return productRepository.findByNameContainingIgnoreCaseAndPriceBetween(name, minPrice, maxPrice);
    }

    public Product updateProduct(Long id, ProductDTO updateProduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setDescription(updateProduct.getDescription());
        return productRepository.save(product);
    }
}
