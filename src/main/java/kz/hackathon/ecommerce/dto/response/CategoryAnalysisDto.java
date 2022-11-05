package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryAnalysisDto {
    private String title;
    private Integer totalAmount;
//    private List<SubCategoryAnalysisDto> subCategories;
}
