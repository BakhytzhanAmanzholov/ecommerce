package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.RequestSeller;

import java.util.List;

public interface RequestSellerService extends CrudService<RequestSeller, Long>{

    List<RequestSeller> findAll();
}
