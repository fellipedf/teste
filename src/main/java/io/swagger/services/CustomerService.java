package io.swagger.services;

import io.swagger.mapper.AddressMapper;
import io.swagger.mapper.CustomerMapper;
import io.swagger.model.Address;
import io.swagger.model.Body;
import io.swagger.model.Customer;
import io.swagger.model.Status;
import io.swagger.model.dto.input.CustomerInputDto;
import io.swagger.model.dto.output.CustomerOutputDto;
import io.swagger.repositories.AddressRepository;
import io.swagger.repositories.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomersRepository customersRepository;
    private final AddressRepository addressRepository;

    public CustomerService(CustomersRepository repository, AddressRepository addressRepository) {
        this.customersRepository = repository;
        this.addressRepository = addressRepository;
    }

    public String save(CustomerInputDto customer) {
        Address address = addressRepository.save(AddressMapper.inputMap(customer.getAddress()));
        Customer save = customersRepository.save(CustomerMapper.inputMap(customer, address));
        return save.getId();
    }

    public CustomerOutputDto findById(String id) {
        Customer customer = customersRepository.findById(id);
        CustomerOutputDto customerOutputDto = CustomerMapper.outputMap(customer);
        return customerOutputDto;
    }

    public List<CustomerOutputDto> findAll(String name, String city, Status status) {
        List<Customer> customerList;
        if (name != null || city != null || status != null) {
            customerList = customersRepository.findByNameAndCityAndStatus(name, city, status);
        } else {
            customerList = customersRepository.findAll();
        }
        List<CustomerOutputDto> customerOutputDtos = customerList.stream()
                .map(CustomerMapper::outputMap).collect(Collectors.toList());
        return customerOutputDtos;
    }

    public CustomerOutputDto update(String id, CustomerInputDto dto) {
        Customer customer = customersRepository.findById(id);
        Customer customerUpdate = CustomerMapper.inputMap(dto, AddressMapper.inputMap(dto.getAddress()));
        customer.setStatus(customerUpdate.getStatus());
        Address address = getMapAddress(customer, customerUpdate);
        customer.setAddress(address);
        customer.setName(customerUpdate.getName());
        return CustomerMapper.outputMap(customersRepository.save(customer));
    }

    private Address getMapAddress(Customer customer, Customer customerUpdate) {
        Address address = customer.getAddress();
        Address addressUpdate = customerUpdate.getAddress();
        address.setCity(addressUpdate.getCity());
        address.setNeighborhood(addressUpdate.getNeighborhood());
        address.setStreet(addressUpdate.getStreet());
        address.setProvince(addressUpdate.getProvince());
        return address;
    }

    public CustomerOutputDto updateStatus(String id, Body body) {
        Customer customer = customersRepository.findById(id);
        customer.setStatus(body.getStatus());
        return CustomerMapper.outputMap(customersRepository.save(customer));
    }

}
