package io.swagger.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "address")
public class Address {

    @Id
    private String id;
    private String street;
    private String neighborhood;
    private String city;
    @Enumerated(EnumType.STRING)
    private ProvinceEnum province;

    public Address() {
    }

    private Address(Builder builder) {
        setId(builder.id);
        setStreet(builder.street);
        setNeighborhood(builder.neighborhood);
        setCity(builder.city);
        setProvince(builder.province);
    }

    public static Builder builder() {
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

    public ProvinceEnum getProvince() {
        return province;
    }

    public void setProvince(ProvinceEnum province) {
        this.province = province;
    }

    public static final class Builder {
        private String id;
        private String street;
        private String neighborhood;
        private String city;
        private ProvinceEnum province;

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

        public Builder province(ProvinceEnum val) {
            province = val;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
