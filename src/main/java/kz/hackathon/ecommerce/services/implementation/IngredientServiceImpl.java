package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.Ingredient;
import kz.hackathon.ecommerce.repositories.IngredientRepository;
import kz.hackathon.ecommerce.services.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;

    @Override
    public Ingredient save(Ingredient entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Ingredient update(Ingredient entity) {
        return null;
    }

    @Override
    public Ingredient findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Ingredient by id <" + aLong + "> not found"));
    }
}
