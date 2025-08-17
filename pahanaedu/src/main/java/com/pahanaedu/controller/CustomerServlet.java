package com.pahanaedu.controller;

import com.pahanaedu.model.Customer;
import com.pahanaedu.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch all customers
        List<Customer> customers = customerService.getAllCustomers();

        // Set as request attribute
        req.setAttribute("customers", customers);

        // Forward to JSP
        req.getRequestDispatcher("/WEB-INF/views/customers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Example: handle adding new customer
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int unitsConsumed = Integer.parseInt(req.getParameter("unitsConsumed"));

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setUnitsConsumed(unitsConsumed);

        customerService.addCustomer(customer);

        resp.sendRedirect("customers"); // redirect to refresh list
    }
}
