package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.RequestSeller;
import kz.hackathon.ecommerce.repositories.RequestSellerRepository;
import kz.hackathon.ecommerce.services.RequestSellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RequestSellerServiceImpl implements RequestSellerService {

    private final RequestSellerRepository repository;

    @Override
    public RequestSeller save(RequestSeller entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public RequestSeller update(RequestSeller entity) {
        RequestSeller request = findById(entity.getId());
        request.setDescription(entity.getDescription());
        return request;
    }

    @Override
    public RequestSeller findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Request by id <" + aLong + "> not found"));
    }

    @Override
    public List<RequestSeller> findAll() {
        return repository.findAll();
    }
}
