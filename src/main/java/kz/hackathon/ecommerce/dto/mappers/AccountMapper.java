package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.RegistrationDto;
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
}
