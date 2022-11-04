package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.mappers.ProductMapper;
import kz.hackathon.ecommerce.dto.mappers.RequestProductMapper;
import kz.hackathon.ecommerce.dto.mappers.RequestSellerMapper;
import kz.hackathon.ecommerce.dto.request.ApproveSellerDto;
import kz.hackathon.ecommerce.dto.request.ProductDto;
import kz.hackathon.ecommerce.dto.response.RequestProductResponseDto;
import kz.hackathon.ecommerce.dto.response.RequestSellerResponseDto;
import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.Product;
import kz.hackathon.ecommerce.models.RequestProduct;
import kz.hackathon.ecommerce.models.RequestSeller;
import kz.hackathon.ecommerce.services.AccountService;
import kz.hackathon.ecommerce.services.ProductService;
import kz.hackathon.ecommerce.services.RequestProductService;
import kz.hackathon.ecommerce.services.RequestSellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final RequestSellerService requestSellerService;

    private final RequestProductService requestProductService;

    private final ProductService productService;

    private final AccountService accountService;

    @GetMapping("/request/sellers")
    public ResponseEntity<?> findAllRequestSeller() {
        List<RequestSeller> requestSellerList = requestSellerService.findAll();
        List<RequestSellerResponseDto> dtoList = new ArrayList<>();
        for (RequestSeller request : requestSellerList) {
            dtoList.add(RequestSellerMapper.toResponseDto(request));
        }
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/request/products")
    public ResponseEntity<?> findAllRequestProduct() {
        List<RequestProduct> requestSellerList = requestProductService.findAll();
        List<RequestProductResponseDto> dtoList = new ArrayList<>();
        for (RequestProduct request : requestSellerList) {
            dtoList.add(RequestProductMapper.toResponseDto(request));
        }
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(ProductMapper.toResponseDto(productService.save(
                ProductMapper.fromRequestDto(productDto)
        )));
    }

    @PatchMapping("/role")
    public ResponseEntity<?> approveSeller(@RequestBody ApproveSellerDto dto) {
        if (accountService.changeRole(dto.getEmail(), Account.Role.SELLER.toString())) {
            return new ResponseEntity<>("Account by email " + dto.getEmail() + " successfully changed role to"
                    + Account.Role.SELLER, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
