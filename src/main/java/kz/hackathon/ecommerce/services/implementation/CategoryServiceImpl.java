package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.Category;
import kz.hackathon.ecommerce.repositories.CategoryRepository;
import kz.hackathon.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Category by id <" + aLong + "> not found"));
    }
}
