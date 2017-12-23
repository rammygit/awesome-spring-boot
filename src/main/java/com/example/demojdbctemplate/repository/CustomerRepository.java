package com.example.demojdbctemplate.repository;

import com.example.demojdbctemplate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository class for JDBC connection.
 */
@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String findAllCustomers = "SELECT id, first_name, last_name FROM customers";

    public List<Customer> findAll() {

        List<Customer> result = jdbcTemplate.query(findAllCustomers,
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));

        return result;

    }





}
