package io.swagger.model.dto;

public class ProductDto {

    private String id;
    private String name;

    private ProductDto(Builder builder) {
        setId(builder.id);
        setName(builder.name);
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

    public static final class Builder {
        private String id;
        private String name;

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

        public ProductDto build() {
            return new ProductDto(this);
        }
    }
}
