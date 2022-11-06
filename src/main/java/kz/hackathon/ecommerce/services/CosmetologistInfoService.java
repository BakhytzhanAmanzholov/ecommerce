package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.CosmetologistInfo;
import kz.hackathon.ecommerce.models.CosmetologistTime;

public interface CosmetologistInfoService extends CrudService<CosmetologistInfo, Long>{

    void addTimeToInfo(CosmetologistInfo cosmetologistInfo, CosmetologistTime time);
}
