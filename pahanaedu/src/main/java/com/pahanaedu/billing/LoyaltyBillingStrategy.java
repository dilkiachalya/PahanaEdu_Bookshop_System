package com.pahanaedu.billing;

import com.pahanaedu.model.Invoice;

public class LoyaltyBillingStrategy implements BillingStrategy {

    @Override
    public double calculate(Invoice invoice) {
        double total = invoice.getQuantity() * invoice.getUnitPrice();
        if (invoice.isLoyalCustomer()) {
            total -= total * 0.05; // 5% loyalty discount
        }
        return total;
    }
}
