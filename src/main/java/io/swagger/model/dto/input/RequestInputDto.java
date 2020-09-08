package io.swagger.model.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RequestInputDto {

    @JsonProperty("id")
    @ApiModelProperty(readOnly = true, value = "Unique identifier")
    private String id;

    @Valid
    @NotNull
    @JsonProperty("product")
    @ApiModelProperty(required = true, value = "")
    private ProductInputDto product;

    @Valid
    @NotNull
    @JsonProperty("customer")
    @ApiModelProperty(required = true, value = "")
    private CustomerInputDto customer;

    @Min(1)
    @Max(10)
    @NotNull
    @JsonProperty("amount")
    @ApiModelProperty(required = true, value = "Product amount of the request")
    private Integer amount;

    @Valid
    @NotNull
    @DecimalMin("0")
    @JsonProperty("value")
    @ApiModelProperty(required = true, value = "Value of the request")
    private BigDecimal value;

    public RequestInputDto() {
    }

    private RequestInputDto(Builder builder) {
        setId(builder.id);
        setProduct(builder.product);
        setCustomer(builder.customer);
        setAmount(builder.amount);
        setValue(builder.value);
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

    public ProductInputDto getProduct() {
        return product;
    }

    public void setProduct(ProductInputDto product) {
        this.product = product;
    }

    public CustomerInputDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInputDto customer) {
        this.customer = customer;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static final class Builder {
        private String id;
        private @Valid @NotNull ProductInputDto product;
        private @Valid @NotNull CustomerInputDto customer;
        private @Min(1) @Max(10) @NotNull Integer amount;
        private @Valid @NotNull @DecimalMin("0") BigDecimal value;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder product(@Valid @NotNull ProductInputDto val) {
            product = val;
            return this;
        }

        public Builder customer(@Valid @NotNull CustomerInputDto val) {
            customer = val;
            return this;
        }

        public Builder amount(@Min(1) @Max(10) @NotNull Integer val) {
            amount = val;
            return this;
        }

        public Builder value(@Valid @NotNull @DecimalMin("0") BigDecimal val) {
            value = val;
            return this;
        }

        public RequestInputDto build() {
            return new RequestInputDto(this);
        }
    }
}
