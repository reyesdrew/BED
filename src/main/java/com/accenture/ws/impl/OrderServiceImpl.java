package com.accenture.ws.impl;

import com.accenture.ws.entity.Order;
import com.accenture.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order order) {
        return orderRepository.save(order);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public double calculateTotalBillWithDiscount(boolean applyDiscount) {
        List<Order> orders = orderRepository.findAll();
        double total = 0.0;
        for (Order order : orders) {
            total += order.getPrice();
        }
        if (applyDiscount) {
            total *= 0.95; // Apply 5% discount
        }
        return total;
    }


}
