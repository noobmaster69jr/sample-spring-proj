package com.crud.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDataAccessService implements CustomerDAO{

    // db

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();

        Customer alex = new Customer (
                1, "alex", 22, "alex222@gmail.com"
        );
        customers.add(alex);

        Customer jamila = new Customer (
                2, "jamila", 22, "jamila72@gmail.com"
        );
        customers.add(jamila);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId.equals(id))
                .findFirst();

    }
}
