package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.InfoProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoProductRepository extends JpaRepository<InfoProduct, Long> {
}
