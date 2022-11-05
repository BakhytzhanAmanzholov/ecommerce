package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.dto.response.AnalysisDto;
import kz.hackathon.ecommerce.dto.response.CategoryAnalysisDto;
import kz.hackathon.ecommerce.exceptions.NotFoundException;
import kz.hackathon.ecommerce.models.*;
import kz.hackathon.ecommerce.repositories.ProductRepository;
import kz.hackathon.ecommerce.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final AccountService accountService;

    private final IngredientService ingredientService;

    private final SubCategoryService subCategoryService;

    private final CategoryService categoryService;

    private final PriceInfoService priceInfoService;

    private final InfoProductService infoProductService;

    @Override
    public Product save(Product entity) {
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

    @Override
    public void addProductsToAccount(Set<Product> products) {
        for (Product product : products) {
            Product realProduct = findById(product.getId());
            Account account = accountService.findByEmail(accountService.isLogged());
            account.getPreferencesProducts().add(realProduct);
        }
    }

    @Override
    public void addIngredientToProduct(Product product, Set<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            Ingredient realIngredient = ingredientService.findById(ingredient.getId());
            Product realProduct = findById(product.getId());
            realProduct.getIngredients().add(realIngredient);
        }
    }

    @Override
    public void updateSubCategory(SubCategory subCategory, Product product) {
        Product realProduct = findById(product.getId());
        SubCategory realSubCategory = subCategoryService.findById(subCategory.getId());

        realProduct.setSubCategory(realSubCategory);
    }

    @Override
    public void updateCategory(Category category, Product product) {
        Product realProduct = findById(product.getId());
        Category realCategory = categoryService.findById(category.getId());

        realProduct.setCategory(realCategory);
    }

    @Override
    public void addPriceInfoToProduct(Product product, PriceInfo priceInfo) {
        Product realProduct = findById(product.getId());
        PriceInfo real = priceInfoService.findById(priceInfo.getId());
        realProduct.getPrices().add(real);
        realProduct = findById(product.getId());
        real = priceInfoService.findById(priceInfo.getId());
        real.setProduct(realProduct);
    }

    @Override
    public void purchaseProduct(Account account, Account seller, Product product, PriceInfo priceInfo) {
        Account realAccount = accountService.findByEmail(account.getEmail());
        Account realSeller = accountService.findByEmail(seller.getEmail());
        Product realProduct = findById(product.getId());
        PriceInfo realInfo = priceInfoService.findById(priceInfo.getId());

        realAccount.getPurchasedProducts().add(
                infoProductService.save(
                        InfoProduct.builder()
                                .price(realInfo.getPrice())
                                .account(realAccount)
                                .product(realProduct)
                                .seller(realSeller.getName())
                                .build()
                )
        );
    }

    @Override
    public AnalysisDto analysis() {
        Account account = accountService.findByEmail(accountService.isLogged());
        List<CategoryAnalysisDto> dtoList = new ArrayList<>();
        dtoList.add(CategoryAnalysisDto.builder()
                .totalAmount(0)
                .title("Декоративная косметика")
                .build());
        dtoList.add(CategoryAnalysisDto.builder()
                .totalAmount(0)
                .title("Уходовая косметика")
                .build());
        dtoList.add(CategoryAnalysisDto.builder()
                .totalAmount(0)
                .title("Парфюмерия")
                .build());

        AnalysisDto analysisDto = AnalysisDto.builder()
                .categories(dtoList)
                .totalAmount(0)
                .build();
        for (InfoProduct infoProduct : account.getPurchasedProducts()) {
            analysisDto.setTotalAmount(analysisDto.getTotalAmount() + infoProduct.getPrice());
            switch (infoProduct.getProduct().getCategory().getTitle()) {
                case "Декоративная косметика":
                    analysisDto.getCategories().get(0).setTotalAmount(
                            analysisDto.getCategories().get(0).getTotalAmount() + infoProduct.getPrice()
                    );

                    break;
                case "Уходовая косметика":
                    analysisDto.getCategories().get(1).setTotalAmount(
                            analysisDto.getCategories().get(1).getTotalAmount() + infoProduct.getPrice()
                    );

                    break;
                case "Парфюмерия":
                    analysisDto.getCategories().get(2).setTotalAmount(
                            analysisDto.getCategories().get(2).getTotalAmount() + infoProduct.getPrice()
                    );

                    break;
            }
        }
        return analysisDto;
    }
}
