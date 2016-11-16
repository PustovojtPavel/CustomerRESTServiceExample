package org.example.core.dao;

import org.example.core.domain.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();
}
