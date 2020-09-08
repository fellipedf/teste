package io.swagger.services;

import io.swagger.mapper.RequestMapper;
import io.swagger.model.Request;
import io.swagger.model.dto.input.RequestInputDto;
import io.swagger.model.dto.output.RequestOutputDto;
import io.swagger.repositories.RequestsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private final RequestsRepository requestsRepository;

    public RequestService(RequestsRepository requestsRepository) {
        this.requestsRepository = requestsRepository;
    }

    public String save(RequestInputDto body) {
        Request request = requestsRepository.save(RequestMapper.inputProductMap(body));
        return request.getId();
    }

    public List<RequestOutputDto> findAll(String customerName, String productName) {
        List<Request> all;
        if (customerName != null || productName != null) {
            all = requestsRepository.findByCustomerAndProduct(customerName, productName);
        } else {
            all = requestsRepository.findAll();
        }
        List<RequestOutputDto> requestOutputDtos = all.stream()
                .map(RequestMapper::outputMap).collect(Collectors.toList());
        return requestOutputDtos;
    }

    public RequestOutputDto findById(String id) {
        Request byId = requestsRepository.findById(id);
        return RequestMapper.outputMap(byId);
    }
}
