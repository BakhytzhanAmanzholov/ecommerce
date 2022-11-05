package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
