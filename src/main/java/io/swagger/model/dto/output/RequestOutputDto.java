package io.swagger.model.dto.output;

import io.swagger.model.dto.CustomerDto;
import io.swagger.model.dto.ProductDto;

import java.math.BigDecimal;

public class RequestOutputDto {

    private String id;
    private ProductDto product;
    private CustomerDto customer;
    private Integer amount;
    private BigDecimal value;

    private RequestOutputDto(Builder builder) {
        setId(builder.id);
        setProduct(builder.product);
        setCustomer(builder.customer);
        setAmount(builder.amount);
        setValue(builder.value);
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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
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
        private ProductDto product;
        private CustomerDto customer;
        private Integer amount;
        private BigDecimal value;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder product(ProductDto val) {
            product = val;
            return this;
        }

        public Builder customer(CustomerDto val) {
            customer = val;
            return this;
        }

        public Builder amount(Integer val) {
            amount = val;
            return this;
        }

        public Builder value(BigDecimal val) {
            value = val;
            return this;
        }

        public RequestOutputDto build() {
            return new RequestOutputDto(this);
        }
    }
}
