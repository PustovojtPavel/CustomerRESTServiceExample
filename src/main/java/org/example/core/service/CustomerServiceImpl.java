package org.example.core.service;

import org.example.core.dao.CustomerDAO;
import org.example.core.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getAll() {
        return customerDAO.getAll();
    }
}
