package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.mappers.AccountMapper;
import kz.hackathon.ecommerce.dto.mappers.RequestProductMapper;
import kz.hackathon.ecommerce.dto.mappers.RequestSellerMapper;
import kz.hackathon.ecommerce.dto.request.RegistrationDto;
import kz.hackathon.ecommerce.dto.request.RequestProductDto;
import kz.hackathon.ecommerce.dto.request.RequestSellerDto;
import kz.hackathon.ecommerce.models.Account;
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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final AccountService accountService;

    private final RequestSellerService requestSellerService;

    private final RequestProductService requestProductService;

    private final ProductService productService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto dto) {
        try {
            accountService.findByEmail(dto.getEmail());
        } catch (UsernameNotFoundException e) {
            Account account = AccountMapper.fromRequestDto(dto);
            account = accountService.save(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/request/seller")
    public ResponseEntity<?> sendRequestToSeller(@RequestBody RequestSellerDto dto) {
        RequestSeller requestSeller = RequestSellerMapper.fromRequestDto(dto);
        requestSeller.setAccount(accountService.findByEmail(accountService.isLogged()));
        requestSellerService.save(requestSeller);
        return new ResponseEntity<>("Request is send", HttpStatus.OK);
    }

    @PostMapping("/request/product")
    public ResponseEntity<?> sendRequestToProduct(@RequestBody RequestProductDto dto) {

        // TODO: сделать в филтре проверку на sellera

        RequestProduct requestProduct = RequestProductMapper.fromRequestDto(dto);
        for (String artifact : dto.getArtifacts()) {
            requestProduct.getProducts().add(productService.findByArtifact(artifact));
        }
        requestProduct.setAccount(accountService.findByEmail(accountService.isLogged()));
        requestProductService.save(requestProduct);

        return new ResponseEntity<>("Request is send", HttpStatus.OK);
    }
}
