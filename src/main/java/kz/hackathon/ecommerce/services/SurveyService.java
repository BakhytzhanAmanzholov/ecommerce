package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyService extends CrudService<Survey, Long> {
    List<Survey> findAll();
}
