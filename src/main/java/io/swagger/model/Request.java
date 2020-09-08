package io.swagger.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity(name = "request")
public class Request {

    @Id
    private String id;
    @OneToOne
    private Product product;
    @OneToOne
    private Customer customer;
    private Integer amount;
    private BigDecimal value;

    public Request() {
    }

    private Request(Builder builder) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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
        private Product product;
        private Customer customer;
        private Integer amount;
        private BigDecimal value;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder customer(Customer val) {
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

        public Request build() {
            return new Request(this);
        }
    }
}
