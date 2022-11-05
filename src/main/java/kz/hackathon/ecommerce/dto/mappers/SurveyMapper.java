package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.response.AnswerDto;
import kz.hackathon.ecommerce.dto.response.SurveyDto;
import kz.hackathon.ecommerce.models.Answer;
import kz.hackathon.ecommerce.models.Survey;

import java.util.ArrayList;

public class SurveyMapper {
    public static SurveyDto toResponseDto(Survey survey){
        SurveyDto dto =  SurveyDto.builder()
                .id(survey.getId())
                .question(survey.getQuestion())
                .answers(new ArrayList<>())
                .build();

        for (Answer answer: survey.getAnswers()){
            dto.getAnswers().add(
                    AnswerDto.builder()
                            .id(answer.getId())
                            .answer(answer.getAnswer())
                            .build()
            );
        }

        return dto;
    }
}
