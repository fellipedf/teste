package io.swagger.model.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ProvinceEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressInputDto {

    @JsonProperty("id")
    private String id;

    @NotNull
    @Size(max = 500)
    @JsonProperty("street")
    @ApiModelProperty(example = "Rua Patagônia, Nº 150", required = true, value = "Street and number description")
    private String street;

    @JsonProperty("neighborhood")
    @ApiModelProperty(required = true, value = "Neighborhood")
    @NotNull
    @Size(max = 250)
    private String neighborhood;

    @NotNull
    @Size(max = 250)
    @JsonProperty("city")
    @ApiModelProperty(required = true, value = "City")
    private String city;


    @NotNull
    @JsonProperty("province")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(required = true, value = "Province")
    private ProvinceEnum province;

    public AddressInputDto() {
    }

    private AddressInputDto(Builder builder) {
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

    public ProvinceEnum getProvince() {
        return province;
    }

    public void setProvince(ProvinceEnum province) {
        this.province = province;
    }

    public static final class Builder {
        private String id;
        private @NotNull @Size(max = 500) String street;
        private @NotNull @Size(max = 250) String neighborhood;
        private @NotNull @Size(max = 250) String city;
        private @NotNull ProvinceEnum province;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder street(@NotNull @Size(max = 500) String val) {
            street = val;
            return this;
        }

        public Builder neighborhood(@NotNull @Size(max = 250) String val) {
            neighborhood = val;
            return this;
        }

        public Builder city(@NotNull @Size(max = 250) String val) {
            city = val;
            return this;
        }

        public Builder province(@NotNull ProvinceEnum val) {
            province = val;
            return this;
        }

        public AddressInputDto build() {
            return new AddressInputDto(this);
        }
    }
}
