package kz.hackathon.ecommerce.dto.response;

import kz.hackathon.ecommerce.models.Account;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestProductResponseDto {
    private Long id;
    private AccountDto account;
    private String description;
    private List<ProductResponseDto> products;
}
