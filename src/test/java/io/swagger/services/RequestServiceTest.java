package io.swagger.services;

import io.swagger.model.Request;
import io.swagger.model.dto.input.RequestInputDto;
import io.swagger.model.dto.output.RequestOutputDto;
import io.swagger.repositories.RequestsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static io.swagger.services.TestBuilders.getRequest;
import static io.swagger.services.TestBuilders.getRequestInputDto;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class RequestServiceTest {

    private final RequestsRepository requestsRepository  = mock(RequestsRepository.class);

    @InjectMocks
    RequestService service;

    @Before
    public void setUp() throws Exception {
        this.service = new RequestService(requestsRepository);
    }

    @Test
    public void save() {

        Request request = getRequest();

        doReturn(request).when(requestsRepository).save(Mockito.any(Request.class));

        RequestInputDto inputDto = getRequestInputDto();

        String save = service.save(inputDto);

        Assert.assertEquals(save, "b6ed007c-0d14-431f-ad34-f9d2cd005ba8");

    }

    @Test
    public void findAll() {
        List<Request> requests = getRequestList();

        doReturn(requests).when(requestsRepository).findAll();

        List<RequestOutputDto> outputDtoList = service.findAll(null, null);

        Assert.assertEquals(outputDtoList.size(), 1);

    }

    private List<Request> getRequestList() {
        List<Request> requests = new ArrayList<>();
        requests.add(getRequest());
        return requests;
    }

    @Test
    public void findById() {
        Request request = getRequest();

        doReturn(request).when(requestsRepository).findById(Mockito.any(String.class));

        RequestOutputDto outputDto = service.findById(request.getId());

        Assert.assertEquals(outputDto.getId(), "b6ed007c-0d14-431f-ad34-f9d2cd005ba8");

    }


}