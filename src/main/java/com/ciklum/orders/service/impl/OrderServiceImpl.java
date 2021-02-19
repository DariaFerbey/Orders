package com.ciklum.orders.service.impl;

import com.ciklum.orders.model.Order;
import com.ciklum.orders.repository.OrderRepository;
import com.ciklum.orders.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order crete(Order order) {
        return repository.save(order);
    }

    @Override
    public Order readById(long id) {
        Optional<Order> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : optional.orElseThrow();
    }

    @Override
    public Order update(Order order) {
        if(order !=null){
            Order oldOrder = readById(order.getId());
            if(oldOrder == null) {
                return null;
            }
        }
        return  repository.save(order);
    }

    @Override
    public void delete(long id) {
        Order order = readById(id);
        if(order != null) {
            repository.delete(order);
        }

    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = repository.findAll();
        return orders.isEmpty() ? new ArrayList<>() : orders;
    }
}
