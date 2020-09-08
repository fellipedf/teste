package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Product;
import io.swagger.annotations.*;
import io.swagger.model.dto.input.ProductInputDto;
import io.swagger.model.dto.output.ProductOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-04T18:20:40.582Z[GMT]")
@Api(value = "products", description = "the products API")
public interface ProductsApi {

    @ApiOperation(value = "List products", nickname = "findProduct", notes = "List products according to the parameters", response = Product.class, tags = {"Products",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ProductOutputDto.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class)})
    @RequestMapping(value = "/products",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<ProductOutputDto>> findProduct(@ApiParam(value = "Client ID", required = true) @RequestHeader(value = "client_id", required = true) String clientId
            , @ApiParam(value = "Product name") @Valid @RequestParam(value = "name", required = false) String name
    );


    @ApiOperation(value = "Find a product", nickname = "findProductById", notes = "Return a product according to the ID", response = Product.class, tags = {"Products",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ProductOutputDto.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class)})
    @RequestMapping(value = "/products/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ProductOutputDto> findProductById(@ApiParam(value = "Client ID", required = true) @RequestHeader(value = "client_id", required = true) String clientId
            , @ApiParam(value = "Unique identifier", required = true) @PathVariable("id") String id
    );


    @ApiOperation(value = "Insert a product", nickname = "insertProduct", notes = "Insert a product", tags = {"Products",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 403, message = "Forbidden", response = String.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class)})
    @RequestMapping(value = "/products",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<String> insertProduct(@ApiParam(value = "Client ID", required = true) @RequestHeader(value = "client_id", required = true) String clientId
            , @ApiParam(value = "") @Valid @RequestBody ProductInputDto body
    ) throws Exception;


    @ApiOperation(value = "Remove a product", nickname = "removeProduct", notes = "Remove a product", tags = {"Products",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 403, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class)})
    @RequestMapping(value = "/products/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> removeProduct(@ApiParam(value = "Client ID", required = true) @RequestHeader(value = "client_id", required = true) String clientId
            , @ApiParam(value = "Unique identifier", required = true) @PathVariable("id") String id
    );

}

