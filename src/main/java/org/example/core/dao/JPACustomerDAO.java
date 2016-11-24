package org.example.core.dao;

import org.example.core.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JPACustomerDAO implements CustomerDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Customer> getAll() {
        return hibernateTemplate.loadAll(Customer.class);
    }

    public Customer findById(UUID customerId) {
        return hibernateTemplate.get(Customer.class, customerId);
    }

    public void insert(Customer customer) {
        customer.setId(UUID.randomUUID());
        hibernateTemplate.save(customer);
    }
}
