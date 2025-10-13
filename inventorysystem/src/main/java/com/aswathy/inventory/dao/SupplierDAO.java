package com.aswathy.inventory.dao;

import com.aswathy.inventory.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addSupplier(Supplier s) {
        String sql = "INSERT INTO suppliers(name, contact) VALUES(?, ?)";
        jdbcTemplate.update(sql, s.getName(), s.getContact());
    }

    public List<Supplier> getAllSuppliers() {
        String sql = "SELECT * FROM suppliers";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Supplier.class));
    }
}