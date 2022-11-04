package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private String artifact;
    private List<PriceInfoDto> prices;
}
