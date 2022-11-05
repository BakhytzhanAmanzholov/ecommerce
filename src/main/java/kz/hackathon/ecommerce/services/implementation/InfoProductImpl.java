package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.InfoProduct;
import kz.hackathon.ecommerce.repositories.InfoProductRepository;
import kz.hackathon.ecommerce.services.InfoProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InfoProductImpl implements InfoProductService {
    private final InfoProductRepository repository;

    @Override
    public InfoProduct save(InfoProduct entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public InfoProduct update(InfoProduct entity) {
        return null;
    }

    @Override
    public InfoProduct findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Information about product by id <" + aLong + "> not found"));
    }
}
