package com.aswathy.inventory.dao;

import com.aswathy.inventory.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SalesDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addSale(Sale sale) {
        String sql = "INSERT INTO sales(product_id, quantity, total) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, sale.getProductId(), sale.getQuantity(), sale.getTotal());
    }

    public List<Sale> getAllSales() {
        String sql = "SELECT * FROM sales";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Sale.class));
    }
}