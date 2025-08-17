package com.pahanaedu.service;

import com.pahanaedu.model.Invoice;
import com.pahanaedu.repository.InvoiceRepository;

import java.util.List;

public class ReportService {

    private InvoiceRepository invoiceRepository;

    public ReportService() {
        this.invoiceRepository = new InvoiceRepository();
    }

    public List<Invoice> generateInvoiceReport() {
        return invoiceRepository.getAllInvoices();
    }

    public double getTotalRevenue() {
        return invoiceRepository.getAllInvoices()
                .stream()
                .mapToDouble(Invoice::getAmount)
                .sum();
    }
}
