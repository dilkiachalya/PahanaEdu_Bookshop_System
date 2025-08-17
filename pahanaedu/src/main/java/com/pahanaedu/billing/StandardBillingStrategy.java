package com.pahanaedu.billing;

import com.pahanaedu.model.Invoice;

public class StandardBillingStrategy implements BillingStrategy {

    private static final double RATE_PER_UNIT = 10.0; // example rate

    @Override
    public double calculate(Invoice invoice) {
        return invoice.getQuantity() * invoice.getUnitPrice();
    }
}
