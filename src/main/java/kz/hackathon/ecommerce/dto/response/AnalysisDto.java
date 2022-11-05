package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnalysisDto {
    private Integer totalAmount;
    private List<CategoryAnalysisDto> categories;
}
