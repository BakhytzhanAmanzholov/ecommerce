package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.CosmetologistInfo;
import kz.hackathon.ecommerce.models.CosmetologistTime;
import kz.hackathon.ecommerce.repositories.CosmetologistInfoRepository;
import kz.hackathon.ecommerce.services.CosmetologistInfoService;
import kz.hackathon.ecommerce.services.CosmetologistTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CosmetologistInfoServiceImpl implements CosmetologistInfoService {
    private final CosmetologistInfoRepository repository;

    private final CosmetologistTimeService cosmetologistTimeService;

    @Override
    public CosmetologistInfo save(CosmetologistInfo entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public CosmetologistInfo update(CosmetologistInfo entity) {
        return null;
    }

    @Override
    public CosmetologistInfo findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Information about cosmetologist by id <" + aLong + "> not found"));
    }

    @Override
    public void addTimeToInfo(CosmetologistInfo cosmetologistInfo, CosmetologistTime time) {
        CosmetologistInfo realInfo = findById(cosmetologistInfo.getId());
        CosmetologistTime realTime = cosmetologistTimeService.findById(time.getId());

        realInfo.getTimes().add(realTime);
    }
}
