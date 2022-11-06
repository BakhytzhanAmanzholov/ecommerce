package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.mappers.AccountMapper;
import kz.hackathon.ecommerce.dto.request.IdsDto;
import kz.hackathon.ecommerce.dto.response.AccountDto;
import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.PriceInfo;
import kz.hackathon.ecommerce.models.Product;
import kz.hackathon.ecommerce.services.AccountService;
import kz.hackathon.ecommerce.services.PriceInfoService;
import kz.hackathon.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AccountController {
    private final ProductService productService;

    private final PriceInfoService priceInfoService;

    private final AccountService accountService;

    @GetMapping("/analysis")
    public ResponseEntity<?> analysis() {
        return new ResponseEntity<>(productService.analysis(), HttpStatus.OK);
    }

    @PostMapping("/buy")
    public ResponseEntity<?> purchaseProduct(@RequestBody IdsDto dto) {
        for (Long id : dto.getIds()) {
            PriceInfo priceInfo = priceInfoService.findById(id);
            productService.purchaseProduct(accountService.findByEmail(accountService.isLogged()),
                    priceInfo.getAccount(), priceInfo.getProduct(), priceInfo
            );
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/preference")
    public ResponseEntity<?> preferencesProduct(@RequestBody IdsDto dto) {
        Set<Product> products = new HashSet<>();
        for (Long id : dto.getIds()) {
            products.add(productService.findById(id));
        }
        productService.addProductsToAccount(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/subscription")
    public ResponseEntity<?> subscription(){
        accountService.subscribe();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cosmetologist")
    public ResponseEntity<?> findAllCosmetologist(){
        if(accountService.findByEmail(accountService.isLogged()).getSubscription().equals(Account.Subscription.ENABLED)){
            List<Account> cosmetologists = accountService.findAllCosmetologist();
            List<AccountDto> accounts = new ArrayList<>();
            for (Account account: cosmetologists){
                accounts.add(AccountMapper.toResponseDto(account));
            }

            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
