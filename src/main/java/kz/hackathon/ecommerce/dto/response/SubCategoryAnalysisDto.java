package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubCategoryAnalysisDto {
    private String title;
    private Integer amount;
}
