package io.swagger.mapper;

import io.swagger.model.Request;
import io.swagger.model.dto.CustomerDto;
import io.swagger.model.dto.ProductDto;
import io.swagger.model.dto.input.RequestInputDto;
import io.swagger.model.dto.output.RequestOutputDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestMapper {
    public static Request inputProductMap(RequestInputDto dto) {

        Request.Builder request = Request.builder();

        return request.id(dto.getId() == null ? UUID.randomUUID().toString() : dto.getId())
                .amount(dto.getAmount())
                .customer(CustomerMapper.inputRequestMap(dto.getCustomer()))
                .product(ProductMapper.inputRequestMap(dto.getProduct()))
                .value(dto.getValue())
                .build();

    }

    public static RequestOutputDto outputMap(Request request) {
        return RequestOutputDto.builder()
                .id(request.getId())
                .amount(request.getAmount())
                .value(request.getValue())
                .customer(CustomerDto.builder().id(request.getCustomer()
                        .getId()).name(request.getCustomer().getName()).build())
                .product(ProductDto.builder().id(request.getProduct()
                        .getId()).name(request.getProduct().getName()).build())
                .build();
    }
}
