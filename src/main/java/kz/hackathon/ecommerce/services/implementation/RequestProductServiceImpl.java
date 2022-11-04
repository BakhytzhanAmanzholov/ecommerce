package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.RequestProduct;
import kz.hackathon.ecommerce.repositories.RequestProductRepository;
import kz.hackathon.ecommerce.services.RequestProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RequestProductServiceImpl implements RequestProductService {

    private final RequestProductRepository repository;

    @Override
    public RequestProduct save(RequestProduct entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public RequestProduct update(RequestProduct entity) {
        RequestProduct request = findById(entity.getId());
        request.setDescription(entity.getDescription());
        return request;
    }

    @Override
    public RequestProduct findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Request by id <" + aLong + "> not found"));
    }

    @Override
    public List<RequestProduct> findAll() {
        return repository.findAll();
    }
}
