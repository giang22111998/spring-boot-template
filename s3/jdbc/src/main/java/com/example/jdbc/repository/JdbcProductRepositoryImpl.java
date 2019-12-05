package com.example.jdbc.repository;

import com.example.jdbc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT (*) FROM products", Integer.class);
    }

    @Override
    public int save(Product product) {
        return jdbcTemplate.update(
                "INSERT INTO products (product_name, category_id, unit_price, product_avatar) values(?, ?, ?, ?)",
                product.getProductName(), product.getCategoryId(), product.getUnitPrice(), product.getProductAvatar());
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    class ProductRowMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet resultSet, int numRow) throws SQLException {
            return new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("product_name"),
                    resultSet.getInt("category_id"),
                    resultSet.getBigDecimal("unit_price"),
                    resultSet.getString("product_avatar"),
                    resultSet.getDate("created_at"),
                    resultSet.getDate("updated_at")
            );
        }
    }

    @Override
    public List<Product> findAll(Integer limit, Integer offset) {
        String query = "SELECT * FROM products LIMIT ?, ?";
        Object[] args = new Object[]{offset, limit};
        List<Product> result = this.jdbcTemplate.query(query, args, new ProductRowMapper());
        return result;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public String getNameById(Integer id) {
        return null;
    }
}
