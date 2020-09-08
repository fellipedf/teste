package io.swagger.repositories;

import io.swagger.model.Customer;
import io.swagger.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    Customer findById(String id);

    @Query(value = "select c from customer c where (:name is null or c.name = :name) and " +
            "(:city is null or c.address.city = :city) and " +
            "(:status is null or c.status = :status) ")
    List<Customer> findByNameAndCityAndStatus(
            @Param("name") String name,
            @Param("city") String city,
//            @Param("customerName") String productName,
            @Param("status") Status status);
    
}
