package com.pahanaedu.service;

import com.pahanaedu.model.Invoice;
import com.pahanaedu.billing.BillingStrategy;
import com.pahanaedu.repository.InvoiceRepository;

import java.util.List;

public class BillingService {

    private InvoiceRepository invoiceRepository;
    private BillingStrategy billingStrategy;

    public BillingService(BillingStrategy billingStrategy) {
        this.invoiceRepository = new InvoiceRepository();
        this.billingStrategy = billingStrategy;
    }

    // ✅ Now accepts an Invoice object
    public double calculateBill(Invoice invoice) {
        return billingStrategy.calculate(invoice);
    }

    public void createInvoice(Invoice invoice) {
        invoiceRepository.addInvoice(invoice);
    }

    public void updateInvoice(Invoice invoice) {
        invoiceRepository.updateInvoice(invoice);
    }

    public void deleteInvoice(int id) {
        invoiceRepository.deleteInvoice(id);
    }

    public Invoice getInvoiceById(int id) {
        return invoiceRepository.getInvoiceById(id);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.getAllInvoices();
    }
}
