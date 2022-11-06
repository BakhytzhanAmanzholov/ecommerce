package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.RegistrationDto;
import kz.hackathon.ecommerce.dto.response.AccountDto;
import kz.hackathon.ecommerce.dto.response.ProductResponseDto;
import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.Product;

import java.util.ArrayList;
import java.util.HashSet;

public class AccountMapper {
    public static Account fromRequestDto(RegistrationDto registrationDto) {
        return Account.builder()
                .email(registrationDto.getEmail())
                .name(registrationDto.getName())
                .surname(registrationDto.getSurname())
                .password(registrationDto.getPassword())
                .banned(true)
                .confirmed(false)
                .role(Account.Role.USER)
                .subscription(Account.Subscription.DISABLED)
                .preferencesProducts(new HashSet<>())
                .build();
    }

    public static AccountDto toResponseDto(Account account) {
        AccountDto dto = AccountDto.builder()
                .id(account.getId())
                .role(account.getRole().toString())
                .email(account.getEmail())
                .name(account.getName())
                .surname(account.getSurname())
                .preferencesProducts(new ArrayList<>())
                .build();

        for (Product product : account.getPreferencesProducts()) {
            ProductResponseDto productDto = ProductMapper.toResponseDto(product);
            productDto.setPrices(new ArrayList<>());
            dto.getPreferencesProducts().add(productDto);
        }

        return dto;
    }
}
