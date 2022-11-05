package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.Product;

import java.util.List;
import java.util.Set;

public interface ProductService extends CrudService<Product, Long>{
    List<Product> findAll();

    Product findByArtifact(String artifact);

    void addProductsToAccount(Set<Product> products);
}
