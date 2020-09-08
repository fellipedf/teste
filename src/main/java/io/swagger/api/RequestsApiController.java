package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Request;
import io.swagger.model.dto.input.RequestInputDto;
import io.swagger.model.dto.output.RequestOutputDto;
import io.swagger.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class RequestsApiController implements RequestsApi {

    private static final Logger log = LoggerFactory.getLogger(RequestsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final RequestService requestService;

    public RequestsApiController(ObjectMapper objectMapper,
                                 HttpServletRequest request,
                                 RequestService requestService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.requestService = requestService;
    }

    public ResponseEntity<List<RequestOutputDto>> findRequest(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Customer name")
            @Valid @RequestParam(value = "customerName", required = false) String customerName,
            @ApiParam(value = "Product name")
            @Valid @RequestParam(value = "productName", required = false) String productName) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return  ResponseEntity.ok().body(requestService.findAll(customerName, productName));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RequestOutputDto> findRequestById(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Unique identifier", required = true)
            @PathVariable("id") String id) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return ResponseEntity.ok().body(requestService.findById(id));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> insertRequest(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "")
            @Valid @RequestBody RequestInputDto body) {

        String accept = request.getHeader("Accept");

        return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(body));
    }

}
