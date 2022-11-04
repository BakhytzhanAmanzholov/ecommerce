package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.RequestSeller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestSellerRepository extends JpaRepository<RequestSeller, Long> {
}
