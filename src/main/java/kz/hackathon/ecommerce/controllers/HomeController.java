package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.mappers.AccountMapper;
import kz.hackathon.ecommerce.dto.request.RegistrationDto;
import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.services.AccountService;
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
}
