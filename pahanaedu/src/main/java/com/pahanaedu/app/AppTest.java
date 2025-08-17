package com.pahanaedu.app;

import com.pahanaedu.model.Invoice;
import com.pahanaedu.billing.*;
import com.pahanaedu.service.BillingService;

public class AppTest {

    public static void main(String[] args) {

        // Create example invoices
        Invoice standardInvoice = new Invoice();
        standardInvoice.setQuantity(10);
        standardInvoice.setUnitPrice(15.0);
        standardInvoice.setLoyalCustomer(false);

        Invoice loyaltyInvoice = new Invoice();
        loyaltyInvoice.setQuantity(20);
        loyaltyInvoice.setUnitPrice(12.0);
        loyaltyInvoice.setLoyalCustomer(true);

        Invoice discountInvoice = new Invoice();
        discountInvoice.setQuantity(5);
        discountInvoice.setUnitPrice(20.0);
        discountInvoice.setLoyalCustomer(false);

        // Use StandardBillingStrategy
        BillingService standardService = new BillingService(new StandardBillingStrategy());
        System.out.println("Standard Bill: " + standardService.calculateBill(standardInvoice));

        // Use LoyaltyBillingStrategy
        BillingService loyaltyService = new BillingService(new LoyaltyBillingStrategy());
        System.out.println("Loyalty Bill: " + loyaltyService.calculateBill(loyaltyInvoice));

        // Use DiscountBillingStrategy
        BillingService discountService = new BillingService(new DiscountBillingStrategy());
        System.out.println("Discount Bill: " + discountService.calculateBill(discountInvoice));
    }
}
