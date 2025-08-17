package com.pahanaedu.service;

import com.pahanaedu.model.Customer;
import com.pahanaedu.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
