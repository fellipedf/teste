package io.swagger.mapper;

import io.swagger.model.Product;
import io.swagger.model.dto.input.ProductInputDto;
import io.swagger.model.dto.output.ProductOutputDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {
    public static Product inputProductMap(ProductInputDto dto) {

        Product.Builder product = Product.builder();

        return product.id(dto.getId() == null ? UUID.randomUUID().toString() : dto.getId())
                .name(dto.getName())
                .value(dto.getValue())
                .build();
    }

    public static Product inputRequestMap(ProductInputDto dto) {
        return Product.builder().id(dto.getId()).build();
    }

    public static ProductOutputDto outputMap(Product product) {
        return ProductOutputDto.builder()
                .id(product.getId())
                .name(product.getName())
                .value(product.getValue())
                .build();
    }
}
