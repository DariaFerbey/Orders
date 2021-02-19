package com.ciklum.orders.service.impl;

import com.ciklum.orders.model.Product;
import com.ciklum.orders.repository.ProductRepository;
import com.ciklum.orders.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product readById(long id) {
        Optional<Product> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : optional.orElseThrow();
    }

    @Override
    public void delete(long id) {
        Product product = readById(id);
        if(product!=null){
            repository.delete(product);
        }
    }

    @Override
    public List<Product> getByProductQuantity() {
        return repository.getByProductQuantity();
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = repository.findAll();
        return products.isEmpty() ? new ArrayList<>() : products;
    }
}
