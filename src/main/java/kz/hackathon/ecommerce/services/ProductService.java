package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.dto.response.AnalysisDto;
import kz.hackathon.ecommerce.models.*;

import java.util.List;
import java.util.Set;

public interface ProductService extends CrudService<Product, Long>{
    List<Product> findAll();

    Product findByArtifact(String artifact);

    void addProductsToAccount(Set<Product> products);

    void addIngredientToProduct(Product product, Set<Ingredient> ingredients);

    void updateSubCategory(SubCategory subCategory, Product product);

    void updateCategory(Category category, Product product);

    void addPriceInfoToProduct(Product product, PriceInfo priceInfo);


    void purchaseProduct(Account account, Account seller, Product product, PriceInfo priceInfo);

    AnalysisDto analysis();
}
