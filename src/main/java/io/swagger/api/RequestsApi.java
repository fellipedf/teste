package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Request;
import io.swagger.annotations.*;
import io.swagger.model.dto.input.RequestInputDto;
import io.swagger.model.dto.output.RequestOutputDto;
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
@Api(value = "requests", description = "the requests API")
public interface RequestsApi {

    @ApiOperation(value = "List requests", nickname = "findRequest", notes = "List requests according to the parameters. It is mandatory to inform customer name or product name", response = Request.class, tags={ "Requests", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Request.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class) })
    @RequestMapping(value = "/requests",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<RequestOutputDto>> findRequest(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
, @ApiParam(value = "Customer name") @Valid @RequestParam(value = "customerName", required = false) String customerName
, @ApiParam(value = "Product name") @Valid @RequestParam(value = "productName", required = false) String productName
);


    @ApiOperation(value = "Find a request", nickname = "findRequestById", notes = "Return a request according to the ID", response = Request.class, tags={ "Requests", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Request.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/requests/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<RequestOutputDto> findRequestById(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
,@ApiParam(value = "Unique identifier",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "Insert a request", nickname = "insertRequest", notes = "Insert a request", tags={ "Requests", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class) })
    @RequestMapping(value = "/requests",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> insertRequest(@ApiParam(value = "Client ID" ,required=true) @RequestHeader(value="client_id", required=true) String clientId
,@ApiParam(value = ""  )  @Valid @RequestBody RequestInputDto body);

}

