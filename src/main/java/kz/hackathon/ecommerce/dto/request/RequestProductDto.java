package kz.hackathon.ecommerce.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestProductDto {
    private String description;
    private List<String> artifacts;
}
