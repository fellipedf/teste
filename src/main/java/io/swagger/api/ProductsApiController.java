package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.dto.input.ProductInputDto;
import io.swagger.model.dto.output.ProductOutputDto;
import io.swagger.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ProductService productService;

    public ProductsApiController(ObjectMapper objectMapper,
                                 HttpServletRequest request,
                                 ProductService productService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.productService = productService;
    }

    public ResponseEntity<List<ProductOutputDto>> findProduct(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Product name")
            @Valid @RequestParam(value = "name", required = false) String name) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return ResponseEntity.ok().body(productService.findAll(name));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ProductOutputDto> findProductById(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Unique identifier", required = true)
            @PathVariable("id") String id) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return ResponseEntity.ok().body(productService.findById(id));
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> insertProduct(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "")
            @Valid @RequestBody ProductInputDto body) throws Exception {

        String accept = request.getHeader("Accept");
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(body));
    }

    public ResponseEntity<Void> removeProduct(
            @ApiParam(value = "Client ID", required = true)
            @RequestHeader(value = "client_id", required = true) String clientId,
            @ApiParam(value = "Unique identifier", required = true)
            @PathVariable("id") String id) {

        String accept = request.getHeader("Accept");
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

}
