package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.RequestProduct;

import java.util.List;

public interface RequestProductService extends CrudService<RequestProduct, Long>{
    List<RequestProduct> findAll();
}
