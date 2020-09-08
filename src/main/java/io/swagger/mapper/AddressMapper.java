package io.swagger.mapper;

import io.swagger.model.Address;
import io.swagger.model.dto.input.AddressInputDto;
import io.swagger.model.dto.output.AddressOutputDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressMapper {

    public static Address inputMap(AddressInputDto dto) {

        Address.Builder address = Address.builder();

        return address.id(dto.getId() == null ? UUID.randomUUID().toString() : dto.getId())
                .city(dto.getCity())
                .neighborhood(dto.getNeighborhood())
                .street(dto.getStreet())
                .province(dto.getProvince())
                .build();
    }

    public static AddressOutputDto outputDto(Address address) {
        return AddressOutputDto.newBuilder()
                .id(address.getId())
                .city(address.getCity())
                .neighborhood(address.getNeighborhood())
                .street(address.getStreet())
                .province(address.getProvince().name())
                .build();
    }
}
