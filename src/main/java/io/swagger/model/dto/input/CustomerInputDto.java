package io.swagger.model.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Status;

import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CustomerInputDto {

    @JsonProperty("id")
    @ApiModelProperty(readOnly = true, value = "Unique identifier")
    private String id;

    @NotNull
    @JsonProperty("name")
    @Size(min = 10, max = 500)
    @ApiModelProperty(required = true, value = "Customer name")
    private String name;

    @OneToOne
    @NotNull
    @Valid
    @JsonProperty("address")
    @ApiModelProperty(required = true, value = "")
    private AddressInputDto address;

    @JsonProperty("status")
    @ApiModelProperty(value = "")
    @Valid
    private Status status;

    public CustomerInputDto() {
    }

    private CustomerInputDto(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAddress(builder.address);
        setStatus(builder.status);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressInputDto getAddress() {
        return address;
    }

    public void setAddress(AddressInputDto address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static final class Builder {
        private String id;
        private @NotNull @Size(min = 10, max = 500) String name;
        private @NotNull @Valid AddressInputDto address;
        private @Valid Status status;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder name(@NotNull @Size(min = 10, max = 500) String val) {
            name = val;
            return this;
        }

        public Builder address(@NotNull @Valid AddressInputDto val) {
            address = val;
            return this;
        }

        public Builder status(@Valid Status val) {
            status = val;
            return this;
        }

        public CustomerInputDto build() {
            return new CustomerInputDto(this);
        }
    }
}
