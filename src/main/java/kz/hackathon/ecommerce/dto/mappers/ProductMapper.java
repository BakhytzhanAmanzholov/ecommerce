package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.ProductDto;
import kz.hackathon.ecommerce.dto.request.RegistrationDto;
import kz.hackathon.ecommerce.dto.response.PriceInfoDto;
import kz.hackathon.ecommerce.dto.response.ProductResponseDto;
import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.PriceInfo;
import kz.hackathon.ecommerce.models.Product;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;

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
                .build();
        for (PriceInfo info : product.getPrices()) {
            dto.getPrices().add(
                    toPriceDto(info)
            );
        }
        return dto;
    }

    private static PriceInfoDto toPriceDto(PriceInfo priceInfo) {
        return PriceInfoDto.builder()
                .seller(AccountMapper.toResponseDto(priceInfo.getAccount()))
                .price(priceInfo.getPrice())
                .delivery(priceInfo.getDelivery())
                .build();
    }
}
