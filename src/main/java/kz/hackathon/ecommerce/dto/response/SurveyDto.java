package kz.hackathon.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SurveyDto {
    private Long id;
    private String question;
    private List<AnswerDto> answers;
}
