package io.swagger.services;

import io.swagger.model.Product;
import io.swagger.model.dto.input.ProductInputDto;
import io.swagger.model.dto.output.ProductOutputDto;
import io.swagger.repositories.ProductsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.List;

import static io.swagger.services.TestBuilders.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private final ProductsRepository repository  = mock(ProductsRepository.class);

    @InjectMocks
    ProductService service;

    @Before
    public void setUp() throws Exception {
        this.service = new ProductService(repository);
    }

    @Test
    public void save() throws Exception {

        Product product = getProduct();
        doReturn(product).when(repository).save(Mockito.any(Product.class));

        ProductInputDto productDto = getProductInputDto();
        String save = service.save(productDto);

        Assert.assertEquals(save, "7514e2b6-a474-4208-974b-29350484fc48");
    }

    @Test
    public void findAll() {
        List<Product> products = getProductList();
        doReturn(products).when(repository).findAll();

        List<ProductOutputDto> productOutputDtos = service.findAll(null);

        Assert.assertEquals(productOutputDtos.size(), 1);
    }
    @Test
    public void findById() {

        Product product = getProduct();
        doReturn(product).when(repository).findById(Mockito.any(String.class));

        ProductOutputDto outputDto = service.findById(product.getId());

        Assert.assertEquals(outputDto.getId(), "7514e2b6-a474-4208-974b-29350484fc48");

    }

    @Test
    public void delete() {
        Product product = getProduct();
        doReturn(product).when(repository).findById(Mockito.any(String.class));

        doNothing().when(repository).delete(Mockito.any(Product.class));

        service.delete(product.getId());

    }




}