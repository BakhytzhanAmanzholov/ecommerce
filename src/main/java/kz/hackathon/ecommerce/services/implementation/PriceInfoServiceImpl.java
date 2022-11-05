package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.PriceInfo;
import kz.hackathon.ecommerce.repositories.PriceInfoRepository;
import kz.hackathon.ecommerce.services.PriceInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PriceInfoServiceImpl implements PriceInfoService {
    private final PriceInfoRepository repository;

    @Override
    public PriceInfo save(PriceInfo entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public PriceInfo update(PriceInfo entity) {
        return null;
    }

    @Override
    public PriceInfo findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Information about price by id <" + aLong + "> not found"));
    }
}
