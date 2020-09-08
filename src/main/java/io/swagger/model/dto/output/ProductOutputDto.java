package io.swagger.model.dto.output;

import java.math.BigDecimal;

public class ProductOutputDto {

    private String id;
    private String name;
    private BigDecimal value;

    private ProductOutputDto(Builder builder) {
        setId(builder.id);
        setName(builder.name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static final class Builder {
        private String id;
        private String name;
        private BigDecimal value;

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

        public Builder value(BigDecimal val) {
            value = val;
            return this;
        }

        public ProductOutputDto build() {
            return new ProductOutputDto(this);
        }
    }
}
