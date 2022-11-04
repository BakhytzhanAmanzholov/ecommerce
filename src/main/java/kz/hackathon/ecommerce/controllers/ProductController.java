package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.mappers.ProductMapper;
import kz.hackathon.ecommerce.dto.request.ProductDto;
import kz.hackathon.ecommerce.dto.response.ProductResponseDto;
import kz.hackathon.ecommerce.models.Product;
import kz.hackathon.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<Product> productList = productService.findAll();
        List<ProductResponseDto> dtoList = new ArrayList<>();

        for (Product product : productList) {
            dtoList.add(ProductMapper.toResponseDto(product));
        }

        return ResponseEntity.ok(dtoList);
    }
}
