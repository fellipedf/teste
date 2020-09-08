package io.swagger.services;

import io.swagger.mapper.ProductMapper;
import io.swagger.model.Product;
import io.swagger.model.dto.input.ProductInputDto;
import io.swagger.model.dto.output.ProductOutputDto;
import io.swagger.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductsRepository repository;

    public ProductService(ProductsRepository repository) {
        this.repository = repository;
    }

    public String save(ProductInputDto product) throws Exception {
        try {
            Product pro = repository.save(ProductMapper.inputProductMap(product));
            return pro.getId();
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }
    }

    public List<ProductOutputDto> findAll(String name) {
        List<Product> all;
        if (name != null) {
            all = repository.findByName(name);
        } else {
            all = repository.findAll();
        }
        List<ProductOutputDto> productsDto = all.stream()
                .map(ProductMapper::outputMap).collect(Collectors.toList());
        return productsDto;
    }

    public ProductOutputDto findById(String id) {
        Product product = repository.findById(id);
        return ProductMapper.outputMap(product);
    }

    public void delete(String id) {
        Product product = repository.findById(id);
        repository.delete(product);
    }
}
