package org.example.variousrequestdatapractice.controller;

import org.example.variousrequestdatapractice.dto.ProductDTO;
import org.example.variousrequestdatapractice.model.Product;
import org.example.variousrequestdatapractice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class ExceptionController {

    private final ProductService productService;

    public ExceptionController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return ResponseEntity.ok("상품 등록 완료");
    }

    //특정 예외 발생 시 적절한 HTTP 상태 코드와 메시지를 반환
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleTllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("잘못된 요청: " + e.getMessage());
    }
}
