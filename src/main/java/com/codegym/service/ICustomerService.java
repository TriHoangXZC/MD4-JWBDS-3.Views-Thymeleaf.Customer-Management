package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> displayAll();

    public int findIndexById(int id);

    Customer findCustomerById(int id);

    void createCustomer(Customer customer);

    void editCustomerById(int id, Customer customer);

    void deleteCustomerById(int id);
}
