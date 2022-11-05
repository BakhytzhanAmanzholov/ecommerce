package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.ProductDto;
import kz.hackathon.ecommerce.dto.response.IngredientDto;
import kz.hackathon.ecommerce.dto.response.PriceInfoDto;
import kz.hackathon.ecommerce.dto.response.ProductResponseDto;
import kz.hackathon.ecommerce.models.Ingredient;
import kz.hackathon.ecommerce.models.PriceInfo;
import kz.hackathon.ecommerce.models.Product;

import java.util.ArrayList;

public class ProductMapper {

    public static Product fromRequestDto(ProductDto productDto) {
        return Product.builder()
                .description(productDto.getDescription())
                .artifact(productDto.getArtifact())
                .title(productDto.getTitle())
                .build();
    }

    public static ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto dto = ProductResponseDto.builder()
                .id(product.getId())
                .artifact(product.getArtifact())
                .prices(new ArrayList<>())
                .description(product.getDescription())
                .title(product.getTitle())
                .category(product.getCategory().getTitle())
                .subCategory(product.getSubCategory().getTitle())
                .ingredients(new ArrayList<>())
                .build();
        for (PriceInfo info : product.getPrices()) {
            dto.getPrices().add(
                    toPriceDto(info)
            );
        }

        for (Ingredient ingredient : product.getIngredients()) {
            dto.getIngredients().add(
                    IngredientDto.builder()
                            .id(ingredient.getId())
                            .healthy(ingredient.getHealthy())
                            .name(ingredient.getName())
                            .build()
            );
        }
        return dto;
    }

    private static PriceInfoDto toPriceDto(PriceInfo priceInfo) {
        return PriceInfoDto.builder()
                .id(priceInfo.getId())
                .seller(AccountMapper.toResponseDto(priceInfo.getAccount()))
                .price(priceInfo.getPrice())
                .delivery(priceInfo.getDelivery())
                .build();
    }
}
