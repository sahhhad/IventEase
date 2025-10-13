package com.aswathy.inventory.dao;

import com.aswathy.inventory.model.Product;
import com.aswathy.inventory.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addProduct(Product p) {
        String sql = "INSERT INTO products(name, quantity, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, p.getName(), p.getQuantity(), p.getPrice());
    }


    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }


}

