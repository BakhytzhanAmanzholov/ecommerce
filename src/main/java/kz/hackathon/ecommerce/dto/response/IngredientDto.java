package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDto {
    private Long id;
    private String name;
    private Boolean healthy;
}
