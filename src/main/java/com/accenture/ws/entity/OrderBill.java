package com.accenture.ws.entity;

import java.util.List;

public abstract class OrderBill {
    private List<Order> orderList;
    private CafeClerk clerk;

    public OrderBill(CafeClerk clerk) {
        this.clerk = clerk;

    }

    // Getters and Setters
    public CafeClerk getClerk() {
        return clerk;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    // Abstract method to be implemented by subclasses
    public abstract double getTotalBill();
}

