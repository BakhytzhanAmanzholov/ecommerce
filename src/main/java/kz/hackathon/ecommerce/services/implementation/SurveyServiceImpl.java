package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.models.Survey;
import kz.hackathon.ecommerce.repositories.SurveyRepository;
import kz.hackathon.ecommerce.services.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository repository;

    @Override
    public Survey save(Survey entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Survey update(Survey entity) {
        return null;
    }

    @Override
    public Survey findById(Long aLong) {
        return null;
    }

    @Override
    public List<Survey> findAll() {
        return repository.findAll();
    }
}
