package org.example.variousrequestdatapractice.controller;

import org.example.variousrequestdatapractice.dto.ProductDTO;
import org.example.variousrequestdatapractice.model.Product;
import org.example.variousrequestdatapractice.repository.ProductRepository;
import org.example.variousrequestdatapractice.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDto) {
        return productService.saveProduct(productDto);
    }
}
