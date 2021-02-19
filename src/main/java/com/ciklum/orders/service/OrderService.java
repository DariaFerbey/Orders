package com.ciklum.orders.service;

import com.ciklum.orders.model.Order;

import java.util.List;

public interface OrderService {
    Order crete(Order order);
    Order readById(long id);
    Order update(Order order);
    void delete(long id);

    List<Order> getAll();
}
