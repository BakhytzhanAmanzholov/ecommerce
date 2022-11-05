package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountDto {
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String role;

    private List<ProductResponseDto> preferencesProducts;
}
