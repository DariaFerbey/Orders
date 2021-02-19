package com.ciklum.orders.service.impl;


import com.ciklum.orders.model.OrderItem;
import com.ciklum.orders.repository.OrderItemRepository;
import com.ciklum.orders.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderIteamServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    public OrderIteamServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderItem> getAll() {
        List<OrderItem> orders = repository.findAll();
        return orders.isEmpty() ? new ArrayList<>() : orders;
    }
}
