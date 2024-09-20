package com.accenture.ws.entity;

import com.accenture.ws.entity.OrderBill;

import java.util.List;

public class RegularBill extends OrderBill {

    public RegularBill(CafeClerk clerk) {
        super(clerk);
    }

    @Override
    public double getTotalBill() {
        List<Order> orders = getOrderList();
        return orders.stream()
                .filter(order -> !order.getIsDiscounted())
                .mapToDouble(Order::getId)
                .sum();
    }
}