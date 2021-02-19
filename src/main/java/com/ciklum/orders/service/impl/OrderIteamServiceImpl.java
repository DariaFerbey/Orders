package com.ciklum.orders.service.impl;


import com.ciklum.orders.model.Order;
import com.ciklum.orders.model.OrderItem;
import com.ciklum.orders.repository.OrderItemRepository;
import com.ciklum.orders.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderIteamServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    public OrderIteamServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem readById(long id) {
        Optional<OrderItem> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : optional.orElseThrow();
    }

    @Override
    public OrderItem update(OrderItem order) {
        if(order !=null){
            OrderItem oldOrder = readById(order.getId());
            if(oldOrder == null) {
                return null;
            }
        }
        return  repository.save(order);
    }


    @Override
    public List<OrderItem> getAll() {
        List<OrderItem> orders = repository.findAll();
        return orders.isEmpty() ? new ArrayList<>() : orders;
    }
}
