package io.swagger.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;


@Entity(name = "customer")
public class Customer {

    @Id
    private String id;
    private String name;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "customer")
    private List<Request> requests;

    private Status status;

    public Customer() {
    }

    private Customer(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAddress(builder.address);
        setRequests(builder.requests);
        setStatus(builder.status);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static final class Builder {
        private String id;
        private String name;
        private Address address;
        private List<Request> requests;
        private Status status;

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

        public Builder address(Address val) {
            address = val;
            return this;
        }

        public Builder requests(List<Request> val) {
            requests = val;
            return this;
        }

        public Builder status(Status val) {
            status = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
