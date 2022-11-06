package kz.hackathon.ecommerce.dto.mappers;

import kz.hackathon.ecommerce.dto.response.CosmetologistDto;
import kz.hackathon.ecommerce.dto.response.CosmetologistInfoDto;
import kz.hackathon.ecommerce.dto.response.CosmetologistTimeDto;
import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.CosmetologistInfo;
import kz.hackathon.ecommerce.models.CosmetologistTime;

import java.util.ArrayList;

public class CosmetologistMapper {
    public static CosmetologistDto toResponseDto(Account account) {
        CosmetologistDto dto = CosmetologistDto.builder()
                .id(account.getId())
                .surname(account.getSurname())
                .name(account.getName())
                .spheres(new ArrayList<>())
                .build();

        for (CosmetologistInfo info : account.getCosmetologistInfos()) {
            CosmetologistInfoDto infoDto = toInfo(info);
            for (CosmetologistTime time : info.getTimes()) {
                infoDto.getTime().add(toTime(time));
            }
            dto.getSpheres().add(infoDto);
        }

        return dto;
    }

    private static CosmetologistInfoDto toInfo(CosmetologistInfo info) {
        return CosmetologistInfoDto.builder()
                .id(info.getId())
                .state(info.getState())
                .price(info.getPrice())
                .time(new ArrayList<>())
                .build();
    }

    private static CosmetologistTimeDto toTime(CosmetologistTime time) {
        CosmetologistTimeDto dto = CosmetologistTimeDto.builder()
                .id(time.getId())
                .time(String.valueOf(time.getTime()))
                .build();
       try {
           dto.setAccount(AccountMapper.toResponseDto(time.getAccount()));
       }
       catch (NullPointerException e){
           dto.setAccount(null);
       }

//        if (dto.getAccount() != null) {
//            dto.setAccount(AccountMapper.toResponseDto(time.getAccount()));
//        }
        return dto;
    }
}
