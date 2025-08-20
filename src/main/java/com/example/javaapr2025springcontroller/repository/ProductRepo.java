package com.example.javaapr2025springcontroller.repository;

import com.example.javaapr2025springcontroller.entity.Product;
import com.example.javaapr2025springcontroller.util.SqlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository //DataAccessException
public class ProductRepo {
    @Autowired
    JdbcTemplate jdbcTemplate; // CRUD

    public List<Product> getALlProducts(){
        RowMapper rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductName(rs.getString("ITEM_NAME"));
                product.setProductDesc(rs.getString("PRODUCT_DESC"));
                return product;
            }
        };
        List<Product> products = jdbcTemplate.query(SqlConstants.FETCH_PRODUCT, rowMapper);
        // fetch from database
        return products;
    }

    public List<Product> getALlProductsWithBeanPropertyRM(){
        List<Product> products = jdbcTemplate.query(SqlConstants.FETCH_PRODUCT, new BeanPropertyRowMapper<>(Product.class));
        return products;
    }
}
