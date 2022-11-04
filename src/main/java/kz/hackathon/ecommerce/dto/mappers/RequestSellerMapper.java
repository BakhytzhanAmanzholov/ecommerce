package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.request.RequestSellerDto;
import kz.hackathon.ecommerce.dto.response.RequestSellerResponseDto;
import kz.hackathon.ecommerce.models.RequestSeller;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestSellerMapper {

    public static RequestSeller fromRequestDto(RequestSellerDto dto) {
        return RequestSeller.builder()
                .description(dto.getDescription())
                .build();
    }

    public static RequestSellerResponseDto toResponseDto(RequestSeller requestSeller) {
        return RequestSellerResponseDto.builder()
                .id(requestSeller.getId())
                .account(AccountMapper.toResponseDto(requestSeller.getAccount()))
                .description(requestSeller.getDescription())
                .build();
    }

}
