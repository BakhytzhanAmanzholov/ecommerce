package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.Answer;
import kz.hackathon.ecommerce.repositories.AnswerRepository;
import kz.hackathon.ecommerce.services.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;

    @Override
    public Answer save(Answer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Answer update(Answer entity) {
        return null;
    }

    @Override
    public Answer findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Answer by id <" + aLong + "> not found"));
    }
}
