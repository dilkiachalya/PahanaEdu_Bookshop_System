package com.pahanaedu.billing;

import com.pahanaedu.model.Invoice;

public interface BillingStrategy {
    double calculate(Invoice invoice);
}
