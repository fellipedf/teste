package io.swagger.repositories;

import io.swagger.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor<Request> {

    Request findById(String id);

    @Query(value = "select rq from request rq where (:customerName is null or rq.customer.name = :customerName) " +
            "and (:productName is null or rq.product.name = :productName) ")
    List<Request> findByCustomerAndProduct(@Param("customerName") String customerName, @Param("productName") String productName);

}
