package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.RequestProductDto;
import kz.hackathon.ecommerce.dto.response.RequestProductResponseDto;
import kz.hackathon.ecommerce.models.Product;
import kz.hackathon.ecommerce.models.RequestProduct;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RequestProductMapper {

    public static RequestProduct fromRequestDto(RequestProductDto dto) {
        return RequestProduct.builder()
                .description(dto.getDescription())
                .build();
    }

    public static RequestProductResponseDto toResponseDto(RequestProduct requestProduct) {
        RequestProductResponseDto dto = RequestProductResponseDto.builder()
                .id(requestProduct.getId())
                .account(AccountMapper.toResponseDto(requestProduct.getAccount()))
                .description(requestProduct.getDescription())
                .products(new ArrayList<>())
                .build();

        for (Product product : requestProduct.getProducts()) {
            dto.getProducts().add(ProductMapper.toResponseDto(product));
        }

        return dto;
    }
}
