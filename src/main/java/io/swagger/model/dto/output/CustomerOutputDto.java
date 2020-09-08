package io.swagger.model.dto.output;

import java.util.List;

public class CustomerOutputDto {

    private String id;
    private String name;
    private AddressOutputDto address;
    private List<RequestOutputDto> requests;
    private String status;

    private CustomerOutputDto(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAddress(builder.address);
        setRequests(builder.requests);
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

    public AddressOutputDto getAddress() {
        return address;
    }

    public void setAddress(AddressOutputDto address) {
        this.address = address;
    }

    public List<RequestOutputDto> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestOutputDto> requests) {
        this.requests = requests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static final class Builder {
        private String id;
        private String name;
        private AddressOutputDto address;
        private List<RequestOutputDto> requests;
        private String status;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder address(AddressOutputDto val) {
            address = val;
            return this;
        }

        public Builder requests(List<RequestOutputDto> val) {
            requests = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public CustomerOutputDto build() {
            return new CustomerOutputDto(this);
        }
    }
}
