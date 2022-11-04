package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.Product;

import java.util.List;

public interface ProductService extends CrudService<Product, Long>{
    List<Product> findAll();

    Product findByArtifact(String artifact);
}
