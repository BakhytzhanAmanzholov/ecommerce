package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.Product;
import kz.hackathon.ecommerce.repositories.ProductRepository;
import kz.hackathon.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product entity) {
        entity.setPrices(new HashSet<>());
        return productRepository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public Product update(Product entity) {
        Product product = findById(entity.getId());
        product.setTitle(entity.getTitle());
        product.setDescription(entity.getDescription());
        product.setArtifact(entity.getArtifact());
        return product;
    }

    @Override
    public Product findById(Long aLong) {
        return productRepository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Product by id <" + aLong + "> not found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByArtifact(String artifact) {
        return productRepository.findByArtifact(artifact).orElseThrow(
                () -> new NotFoundException("Product by artifact <" + artifact + "> not found"));
    }
}
