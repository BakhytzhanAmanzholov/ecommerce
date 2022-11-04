package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.RequestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestProductRepository extends JpaRepository<RequestProduct, Long> {
}
