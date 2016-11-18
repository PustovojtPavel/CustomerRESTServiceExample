package org.example.core.dao;

import org.example.core.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Component
public class JDBCCustomerDAO implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_CUSTOMERS = "select * from test.customer";
    private static final String SQL_GET_CUSTOMER_BY_ID = "select * from test.customer where id = ?";
    private static final String SQL_INSERT_CUSTOMER = "insert into test.customer (id, name) values (?,?)";

    public List<Customer> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_CUSTOMERS,
                new RowMapper<Customer>() {
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Customer customer = new Customer();
                        customer.setId(UUID.fromString(rs.getString("id")));
                        customer.setName(rs.getString("name"));
                        return customer;
                    }
                });
    }

    public Customer findById(UUID customerId) {
        return jdbcTemplate.queryForObject(SQL_GET_CUSTOMER_BY_ID,
                new Object[] {customerId},
                new RowMapper<Customer>() {
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Customer customer = new Customer();
                        customer.setId(UUID.fromString(rs.getString("id")));
                        customer.setName(rs.getString("name"));
                        return customer;
                    }
                });
    }

    @Override
    public void insert(Customer customer) {
        jdbcTemplate.update(SQL_INSERT_CUSTOMER,
                new Object[] {customer.getId(), customer.getName()});
    }
}
