package com.ciklum.orders.repository;

import com.ciklum.orders.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query(value = "select name, price, status from product p " +
            "join order_items oi on p.id=oi.product_id where oi.quantity > 0 order by name desc", nativeQuery = true)
    List<Product> getByProductQuantity();

}
