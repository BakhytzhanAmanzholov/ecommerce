package kz.hackathon.ecommerce.dto.request;

import lombok.Data;

@Data
public class RegistrationDto {
    private String email;
    private String name;
    private String surname;
    private String password;
}
