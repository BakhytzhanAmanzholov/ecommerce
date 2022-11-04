package kz.hackathon.ecommerce.dto.request;

import lombok.Data;

@Data
public class ChangeRoleDto {
    private String email;
    private String role;
}
