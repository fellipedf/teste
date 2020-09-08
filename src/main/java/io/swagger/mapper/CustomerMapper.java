package io.swagger.mapper;

import io.swagger.model.Address;
import io.swagger.model.Customer;
import io.swagger.model.dto.input.CustomerInputDto;
import io.swagger.model.dto.output.AddressOutputDto;
import io.swagger.model.dto.output.CustomerOutputDto;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public static Customer inputMap(CustomerInputDto dto, Address address) {

        Customer.Builder customer = Customer.builder();

        return customer.id(dto.getId() == null ? UUID.randomUUID().toString() : dto.getId())
                .name(dto.getName())
                .address(address)
                .status(dto.getStatus())
                .build();
    }

    public static Customer inputRequestMap(CustomerInputDto dto) {
        return Customer.builder().id(dto.getId()).build();
    }

    public static CustomerOutputDto outputMap(Customer customer) {
        return CustomerOutputDto.newBuilder()
                .id(customer.getId())
                .address( AddressMapper.outputDto(customer.getAddress()))
                .name(customer.getName())
                .requests(customer.getRequests().stream().map(RequestMapper::outputMap)
                        .collect(Collectors.toList()))
                .status(customer.getStatus().name())
                .build();

    }
}
