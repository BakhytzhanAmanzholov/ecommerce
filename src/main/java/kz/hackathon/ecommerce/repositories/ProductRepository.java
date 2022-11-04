package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByArtifact(String artifact);
}
