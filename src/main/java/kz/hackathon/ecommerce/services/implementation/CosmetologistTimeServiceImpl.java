package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.CosmetologistTime;
import kz.hackathon.ecommerce.repositories.CosmetologistTimeRepository;
import kz.hackathon.ecommerce.services.CosmetologistTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CosmetologistTimeServiceImpl implements CosmetologistTimeService {
    private final CosmetologistTimeRepository repository;

    @Override
    public CosmetologistTime save(CosmetologistTime entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public CosmetologistTime update(CosmetologistTime entity) {
        return null;
    }

    @Override
    public CosmetologistTime findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Information about cosmetologist by id <" + aLong + "> not found"));
    }
}
