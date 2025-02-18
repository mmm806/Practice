package org.example.variousrequestdatapractice.controller;

import org.example.variousrequestdatapractice.dto.ProductForm;
import org.example.variousrequestdatapractice.model.Product;
import org.example.variousrequestdatapractice.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/form")
    public String showProductForm() {
        return "productForm";
    }

    @PostMapping("/form")
    public String submitProductForm(@ModelAttribute ProductForm productForm, Model model) {
        Product product = Product.builder()
                .name(productForm.getName())
                .price(productForm.getPrice())
                .description(productForm.getDescription())
                .build();
        productRepository.save(product);

        model.addAttribute("product", product);
        return "productResult";
    }

}
