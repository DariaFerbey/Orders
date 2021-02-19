package com.ciklum.orders.service;


import com.ciklum.orders.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem readById(long id);
    OrderItem update(OrderItem order);
    List<OrderItem> getAll();
}
