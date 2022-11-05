package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
