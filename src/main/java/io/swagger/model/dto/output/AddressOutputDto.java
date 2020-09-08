package io.swagger.model.dto.output;

public class AddressOutputDto {

    private String id;
    private String street;
    private String neighborhood;
    private String city;
    private String province;

    private AddressOutputDto(Builder builder) {
        setId(builder.id);
        setStreet(builder.street);
        setNeighborhood(builder.neighborhood);
        setCity(builder.city);
        setProvince(builder.province);
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public static final class Builder {
        private String id;
        private String street;
        private String neighborhood;
        private String city;
        private String province;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder street(String val) {
            street = val;
            return this;
        }

        public Builder neighborhood(String val) {
            neighborhood = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder province(String val) {
            province = val;
            return this;
        }

        public AddressOutputDto build() {
            return new AddressOutputDto(this);
        }
    }
}
