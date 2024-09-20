package com.accenture.ws.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("DISCOUNTED")
public class DiscountedBill extends OrderBill {
    private static final double DISCOUNT_RATE = 0.05; // 5% discount

    // Constructor
    public DiscountedBill(CafeClerk clerk) {
        super(clerk);
    }

    // Method to calculate the total bill with discount
    @Override
    public double getTotalBill() {
        double total = 0.0;
        for (Order order : getOrderList()) {
            total += order.getPrice();
        }
        return total * (1 - DISCOUNT_RATE);
    }
}