package org.example.core.dao;

import org.example.core.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDAO {
    List<Customer> getAll();
    Customer findById(UUID customerId);
    void insert(Customer customer);
}
