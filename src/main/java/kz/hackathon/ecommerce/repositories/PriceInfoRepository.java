package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.PriceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceInfoRepository extends JpaRepository<PriceInfo, Long> {
}
