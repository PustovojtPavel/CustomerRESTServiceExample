package org.example.core.service;

import org.example.core.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAll();
    Customer findById(UUID customerId);
    void create(String name);
}
