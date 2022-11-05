package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.SubCategory;
import kz.hackathon.ecommerce.repositories.SubCategoryRepository;
import kz.hackathon.ecommerce.services.SubCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository repository;

    @Override
    public SubCategory save(SubCategory entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public SubCategory update(SubCategory entity) {
        return null;
    }

    @Override
    public SubCategory findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("SubCategory by id <" + aLong + "> not found"));
    }
}
