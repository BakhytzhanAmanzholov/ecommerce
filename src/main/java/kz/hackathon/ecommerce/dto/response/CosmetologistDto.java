package kz.hackathon.ecommerce.dto.response;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CosmetologistDto {
    private Long id;
    private String name;
    private String surname;
    private List<CosmetologistInfoDto> spheres;
}
