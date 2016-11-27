package org.example.core.service;

import org.example.core.dao.CustomerDAO;
import org.example.core.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    public Customer findById(UUID customerId) {
        return customerDAO.findById(customerId);
    }

    public void create(String name) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setName(name);
        customerDAO.insert(customer);
    }
}
