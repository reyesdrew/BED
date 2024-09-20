package com.accenture.ws.controller;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.DiscountedBill;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.RegularBill;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderAndBillingController {
    private final OrderRepository orderRepo;
    private final CafeClerk clerk;

    @Autowired
    public OrderAndBillingController(CafeClerk clerk, OrderRepository orderRepo) {
        this.clerk = clerk;
        this.clerk.setName("Jane Doe");
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public List<Order> getOrderList() {
        return orderRepo.findAll();
    }

    @GetMapping("/totalRegularBill")
    public OrderBill getTotalRegularBill() {
        RegularBill regularBill = new RegularBill(clerk);
        regularBill.setOrderList(orderRepo.findAll());
        return regularBill;
    }

    @GetMapping("/totalDiscountedBill")
    public OrderBill getTotalDiscountedBill() {
        DiscountedBill discountedBill = new DiscountedBill(clerk);
        discountedBill.setOrderList(orderRepo.findAll());
        return discountedBill;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        if (!order.getIsDiscounted()){
            order.setIsDiscountedPercentage(0.00);
        }
        return orderRepo.save(order);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderRepo.findById(id)
                .map(order -> {
                    order.setOrderName(orderDetails.getOrderName());
                    order.setPrice(orderDetails.getPrice());
                    order.setIsDiscounted(orderDetails.getIsDiscounted());
                    order.setIsDiscountedPercentage(orderDetails.getIsDiscountedPercentage());
                    return orderRepo.save(order);
                })
                .orElseGet(() -> {
                    orderDetails.setId(id);
                    return orderRepo.save(orderDetails);
                });
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepo.deleteById(id);
    }

    public void updateOrder(Order order) {
        orderRepo.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepo.delete(order);
    }
}