package com.ciklum.orders.service;

import com.ciklum.orders.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product readById(long id);
    void delete(long id);

    List<Product> getByProductQuantity();
    List<Product> getAll();
}
