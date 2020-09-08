package io.swagger.services;

import io.swagger.model.*;
import io.swagger.model.dto.input.AddressInputDto;
import io.swagger.model.dto.input.CustomerInputDto;
import io.swagger.model.dto.output.CustomerOutputDto;
import io.swagger.repositories.AddressRepository;
import io.swagger.repositories.CustomersRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.List;

import static io.swagger.services.TestBuilders.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomersRepository customersRepository = mock(CustomersRepository.class);
    private AddressRepository addressRepository = mock(AddressRepository.class);

    @InjectMocks
    CustomerService service;

    @Before
    public void setUp() throws Exception {
        this.service = new CustomerService(customersRepository, addressRepository);
    }


    @Test
    public void save() {

        AddressInputDto addressInputDto = getAddressInputDto();

        CustomerInputDto customerInputDto = getCustomerInputDto(addressInputDto);

        Address address = getAddressWithId();

        Customer customer = getCustomer(address);

        doReturn(address).when(addressRepository).save(Mockito.any(Address.class));

        doReturn(customer).when(customersRepository).save(Mockito.any(Customer.class));

        String save = service.save(customerInputDto);

        Assert.assertEquals(save, "54b5cfea-07f0-40bf-9984-186e83522845");
    }


    @Test
    public void findById() {
        Address address = getAddressWithId();
        Customer customer = getCustomer(address);
        customer.setRequests(getRequests());
        doReturn(customer).when(customersRepository).findById(Mockito.any(String.class));

        CustomerOutputDto outputDto = service.findById(customer.getId());

        Assert.assertEquals(customer.getId(), "54b5cfea-07f0-40bf-9984-186e83522845");
    }


    @Test
    public void findAll() {

        List<Customer> customerList = getCustomerList();

        doReturn(customerList).when(customersRepository).findAll();

        List<CustomerOutputDto> customers = service.findAll(null, null, null);

        Assert.assertEquals(customers.size(), 1);

    }


    @Test
    public void update() {

        Customer customer = getCustomer(getAddressWithId());
        customer.setRequests(getRequests());
        doReturn(customer).when(customersRepository).findById(Mockito.any(String.class));

        doReturn(customer).when(customersRepository).save(Mockito.any(Customer.class));
        AddressInputDto addressInputDto = getAddressInputDto();
        addressInputDto.setId("5d1006d9-f057-4c93-8706-c8aecfe4ad6d");
        CustomerInputDto customerInputDto = getCustomerInputDto(addressInputDto);

        CustomerOutputDto updated = service.update("54b5cfea-07f0-40bf-9984-186e83522845", customerInputDto);

        Assert.assertEquals(updated.getId(), "54b5cfea-07f0-40bf-9984-186e83522845");

    }

}
