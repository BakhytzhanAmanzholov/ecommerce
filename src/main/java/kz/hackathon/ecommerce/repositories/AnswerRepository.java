package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
