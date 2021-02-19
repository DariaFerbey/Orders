package com.ciklum.orders.controller;

import com.ciklum.orders.model.Order;
import com.ciklum.orders.model.OrderItem;
import com.ciklum.orders.model.ProductsStatus;
import com.ciklum.orders.service.OrderItemService;
import com.ciklum.orders.service.OrderService;
import com.ciklum.orders.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {

    public final OrderService orderService;
    public final ProductService productService;
    public final OrderItemService orderItemService;

    public OrderController(OrderService orderService, OrderItemService orderItemService, ProductService productService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.productService=productService;
    }

    @GetMapping("/create")
    public String create( Model model) {
        model.addAttribute("order", new Order());
        return "create-order";
    }

    @PostMapping("/create")
    public String create(Model model,
                         @Validated @ModelAttribute("order") Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "create-product";
        }

        orderService.crete(order);
        return "redirect:/orders/all";
    }

    @GetMapping("/{orderItem_id}/update")
    public String update(@PathVariable long orderItem_id, Model model) {
        OrderItem order = orderItemService.readById(orderItem_id);
        model.addAttribute("order", order);
        return "update-order";
    }


    @PostMapping("/{orderItem_id}/update")
    public String update(@PathVariable("orderItem_id") long orderItem_id, @Validated @ModelAttribute("order") OrderItem order, BindingResult result) {
        if (result.hasErrors()) {
            order.setProduct(productService.readById(orderItem_id));
            order.setOrder(orderService.readById(orderItem_id));
            return "update-order";
        }
        OrderItem oldOrderItem = orderItemService.readById(orderItem_id);
        order.setProduct(oldOrderItem.getProduct());
        order.setOrder(oldOrderItem.getOrder());
        orderItemService.update(order);
        return "redirect:/orders/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("orderItems",orderItemService.getAll());
        return "orders-info";
    }
}
