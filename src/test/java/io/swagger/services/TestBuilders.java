package io.swagger.services;

import io.swagger.model.*;
import io.swagger.model.dto.input.AddressInputDto;
import io.swagger.model.dto.input.CustomerInputDto;
import io.swagger.model.dto.input.ProductInputDto;
import io.swagger.model.dto.input.RequestInputDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestBuilders {

    public static List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(getProduct());
        return products;
    }

    public static Product getProduct() {
        Product product = new Product();
        product.setId("7514e2b6-a474-4208-974b-29350484fc48");
        product.setName("Product 1");
        product.setValue(BigDecimal.TEN);
        return product;
    }

    public static ProductInputDto getProductInputDto() {
        ProductInputDto product = new ProductInputDto();
        product.setName("Product 1");
        product.setValue(BigDecimal.TEN);
        return product;
    }

    public static List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = getCustomer(getAddressWithId());
        customer.setRequests(getRequests());
        customerList.add(customer);
        return customerList;
    }

    public static List<Request> getRequests() {

        List<Request> requests = new ArrayList<>();
        requests.add(
                Request.builder().product(
                        Product.builder()
                                .id("109dfd59-7c1d-4a2f-abad-fe169c27d9d9")
                                .name("Product 1")
                                .value(BigDecimal.TEN).build())
                        .customer(Customer.builder()
                                .id("54b5cfea-07f0-40bf-9984-186e83522845")
                                .name("Customer 1")
                                .address(getAddressWithId()).build())
                        .id("54b5cfea-07f0-40bf-9984-186e83522845")
                        .amount(3).value(BigDecimal.ONE)
                        .build());


        return requests;
    }

    public static CustomerInputDto getCustomerInputDto(AddressInputDto addressInputDto) {
        return CustomerInputDto.newBuilder()
                .address(addressInputDto).name("Customer1").status(Status.ON).build();
    }

    public static AddressInputDto getAddressInputDto() {
        return AddressInputDto.newBuilder()
                .city("Curitiba").neighborhood("CIC").province(ProvinceEnum.SP)
                .street("Rua 1").build();
    }

    public static Address getAddressWithId() {
        return Address.builder()
                .id("5d1006d9-f057-4c93-8706-c8aecfe4ad6d")
                .city("Curitiba").neighborhood("CIC").province(ProvinceEnum.SP)
                .street("Rua 1").build();
    }

    public static Customer getCustomer(Address address) {
        return Customer.builder()
                .id("54b5cfea-07f0-40bf-9984-186e83522845")
                .name("Customer1").status(Status.ON).address(address).build();
    }

    public static Request getRequest() {
        Request request = Request.builder()
                .id("b6ed007c-0d14-431f-ad34-f9d2cd005ba8")
                .customer(getCustomer(getAddressWithId()))
                .product(getProduct()).amount(1)
                .value(BigDecimal.ONE)
                .build();
        return request;
    }

    public static RequestInputDto getRequestInputDto() {
        RequestInputDto inputDto = RequestInputDto.newBuilder()
                .id("b6ed007c-0d14-431f-ad34-f9d2cd005ba8")
                .customer(getCustomerInputDto(getAddressInputDto()))
                .product(getProductInputDto()).amount(1)
                .value(BigDecimal.ONE)
                .build();
        return inputDto;
    }

}
