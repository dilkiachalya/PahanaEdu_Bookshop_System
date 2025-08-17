package com.pahanaedu.model;

import java.util.Date;

public class Invoice {
    private int id;
    private int customerId;
    private int itemId;
    private int quantity;
    private double unitPrice;
    private boolean loyalCustomer;
    private double amount; // Add amount for InvoiceRepository

    private Date date;

    public Invoice() {}

    public Invoice(int id, int customerId, int itemId, int quantity, double unitPrice, boolean loyalCustomer) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.loyalCustomer = loyalCustomer;
        this.amount = quantity * unitPrice;
        this.date = new Date();
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public boolean isLoyalCustomer() { return loyalCustomer; }
    public void setLoyalCustomer(boolean loyalCustomer) { this.loyalCustomer = loyalCustomer; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}

