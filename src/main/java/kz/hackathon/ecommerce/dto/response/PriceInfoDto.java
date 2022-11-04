package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceInfoDto {
    private AccountDto seller;
    private String delivery;
    private String price;
}
