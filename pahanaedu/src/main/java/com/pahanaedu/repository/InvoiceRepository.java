package com.pahanaedu.repository;

import com.pahanaedu.model.Invoice;
import com.pahanaedu.app.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private Connection connection;

    public InvoiceRepository() {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoices (id, customer_id, item_id, quantity, unit_price, loyal_customer) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, invoice.getId());
            stmt.setInt(2, invoice.getCustomerId());
            stmt.setInt(3, invoice.getItemId());
            stmt.setInt(4, invoice.getQuantity());
            stmt.setDouble(5, invoice.getUnitPrice());
            stmt.setBoolean(6, invoice.isLoyalCustomer());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInvoice(Invoice invoice) {
        String sql = "UPDATE invoices SET customer_id=?, item_id=?, quantity=?, unit_price=?, loyal_customer=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, invoice.getCustomerId());
            stmt.setInt(2, invoice.getItemId());
            stmt.setInt(3, invoice.getQuantity());
            stmt.setDouble(4, invoice.getUnitPrice());
            stmt.setBoolean(5, invoice.isLoyalCustomer());
            stmt.setInt(6, invoice.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInvoice(int id) {
        String sql = "DELETE FROM invoices WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Invoice getInvoiceById(int id) {
        String sql = "SELECT * FROM invoices WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Invoice(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("item_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getBoolean("loyal_customer")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Invoice(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getInt("item_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getBoolean("loyal_customer")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
