package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSellerResponseDto {
    private Long id;
    private AccountDto account;
    private String description;
}
