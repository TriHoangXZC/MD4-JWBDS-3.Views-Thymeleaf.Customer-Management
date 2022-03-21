package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService{
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add( new Customer(1, "John", "john@codegym.vn", "Ha Noi"));
        customers.add( new Customer(2, "Bill", "bill@codegym.vn", "Da Nang"));
        customers.add( new Customer(3, "Alex", "alex@codegym.vn", "Sai Gon"));
        customers.add( new Customer(4, "Adam", "adam@codegym.vn", "Wu Han"));
        customers.add( new Customer(5, "Sophia", "sophia@codegym.vn", "Chicago"));
        customers.add( new Customer(6, "Rose", "rose@codegym.vn", "New York"));
    }

    @Override
    public List<Customer> displayAll() {
        return customers;
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Customer findCustomerById(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            return customers.get(index);
        }
        return null;
    }

    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void editCustomerById(int id, Customer customer) {
        int index = findIndexById(id);
        customers.set(index, customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        int index = findIndexById(id);
        customers.remove(index);
    }
}
