package org.example.variousrequestdatapractice.controller;

import org.example.variousrequestdatapractice.dto.ProductDTO;
import org.example.variousrequestdatapractice.model.Product;
import org.example.variousrequestdatapractice.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductUpdateController {

    private final ProductService productService;

    public ProductUpdateController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDTO updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }
}
