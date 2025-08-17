package com.pahanaedu.billing;

import com.pahanaedu.model.Invoice;

public class DiscountBillingStrategy implements BillingStrategy {

    private static final double DISCOUNT = 0.1; // 10% discount

    @Override
    public double calculate(Invoice invoice) {
        double total = invoice.getQuantity() * invoice.getUnitPrice();
        return total - (total * DISCOUNT);
    }
}
