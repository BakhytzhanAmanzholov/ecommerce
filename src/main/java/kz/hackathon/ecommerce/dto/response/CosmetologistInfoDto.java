package kz.hackathon.ecommerce.dto.response;

import kz.hackathon.ecommerce.models.CosmetologistInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CosmetologistInfoDto {
    private Long id;
    private CosmetologistInfo.Sphere state;
    private Integer price;
    private List<CosmetologistTimeDto> time;
}
