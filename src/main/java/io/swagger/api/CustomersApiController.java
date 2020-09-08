package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.Customer;
import io.swagger.model.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.dto.input.CustomerInputDto;
import io.swagger.model.dto.output.CustomerOutputDto;
import io.swagger.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-04T18:20:40.582Z[GMT]")
@Controller
public class CustomersApiController implements CustomersApi {

    private static final Logger log = LoggerFactory.getLogger(CustomersApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final CustomerService service;

    public CustomersApiController(ObjectMapper objectMapper, HttpServletRequest request, CustomerService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    public ResponseEntity<List<CustomerOutputDto>> findCustomer(@ApiParam(value = "Client ID", required = true) @RequestHeader(value = "client_id", required = true) String clientId
            , @Min(0L) @ApiParam(value = "It indicates from which index data should be returned. For example, inputing _offset=100 means that pagination should start from the 101st record", allowableValues = "", defaultValue = "0") @Valid @RequestParam(value = "_offset", required = false, defaultValue = "0") Long _offset
            , @Min(0L) @Max(100L) @ApiParam(value = "It indicates how many records are to be returned from the _offset. For example, inputing _limit=100 means that the pagination must return a maximum of 100 records", allowableValues = "", defaultValue = "100") @Valid @RequestParam(value = "_limit", required = false, defaultValue = "100") Long _limit
            , @ApiParam(value = "It indicates which attributes the results list should be ordered by. For example, inputing _sort=[name,age] means that the list must be ordered by the name and age attributes. If any attribute does not exist, it must be ignored") @Valid @RequestParam(value = "_sort", required = false) List<String> _sort
            , @ApiParam(value = "It indicates which attributes are to be returned. For example, inputing _fields=[name,age] means that the list must contain only those attributes. If any attribute does not exist, it must be ignored") @Valid @RequestParam(value = "_fields", required = false) List<String> _fields
            , @ApiParam(value = "Customer name") @Valid @RequestParam(value = "name", required = false) String name
            , @ApiParam(value = "City of the customer's address") @Valid @RequestParam(value = "city", required = false) String city
            , @ApiParam(value = "Product name that was requested by a customer") @Valid @RequestParam(value = "productName", required = false) String productName
            , @ApiParam(value = "Customer status") @Valid @RequestParam(value = "status", required = false) Status status
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return ResponseEntity.ok().body(service.findAll(name, city, status));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerOutputDto> findCustomerById(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Unique identifier", required = true)
            @PathVariable("id") String id) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return ResponseEntity.ok().body(service.findById(id));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> insertCustomer(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "")
            @Valid @RequestBody CustomerInputDto body) {

        String accept = request.getHeader("Accept");

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(body));
    }

    public ResponseEntity<CustomerOutputDto> updateCustomer(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Unique identifier", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "")
            @Valid @RequestBody CustomerInputDto body
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(id, body));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CustomerOutputDto> updateCustomerStatus(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Unique identifier", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "")
            @Valid @RequestBody Body body
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
               return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateStatus(id, body));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

}
