package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
