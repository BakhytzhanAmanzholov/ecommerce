package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.RegistrationDto;
import kz.hackathon.ecommerce.dto.response.AccountDto;
import kz.hackathon.ecommerce.models.Account;

public class AccountMapper {
    public static Account fromRequestDto(RegistrationDto registrationDto){
        return Account.builder()
                .email(registrationDto.getEmail())
                .name(registrationDto.getName())
                .surname(registrationDto.getSurname())
                .password(registrationDto.getPassword())
                .banned(true)
                .confirmed(false)
                .build();
    }

    public static AccountDto toResponseDto(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .role(account.getRole().toString())
                .email(account.getEmail())
                .name(account.getName())
                .surname(account.getSurname())
                .build();
    }
}
