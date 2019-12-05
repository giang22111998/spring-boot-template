package com.example.jdbc.repository;

import com.example.jdbc.model.Order;
import com.example.jdbc.model.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component("JdbcOrderRepositoryImpl")
public class JdbcOrderRepositoryImpl implements OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(JdbcOrderRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM orders", Integer.class);
    }

    @Override
    public int save(Order order) {
        return 0;
    }

    @Override
    public int update(Order order) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    class OrderResultSetExtractor implements ResultSetExtractor<List<Order>> {
        @Override
        public List<Order> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Order> orders = new ArrayList<>();
            Order currentOrder = null;
            List<OrderDetail> currentOrderDetails = new ArrayList<>();
            while (resultSet.next()) {
                currentOrder = new Order();
                //TODO: set order
                currentOrderDetails = new ArrayList<>();
                OrderDetail orderDetail = new OrderDetail();
                //TODO: set order detail
                currentOrderDetails.add(orderDetail);
                currentOrder.setOrderDetails(currentOrderDetails);
                orders.add(currentOrder);
            }
            return orders;
        }
    }

    @Override
    public List<Order> findAll(int limit, int offset) {
        String sql = "SELECT * FROM orders \n" +
                " JOIN order_details ON orders.order_id = order_details.order_detail_id\n" +
                " LEFT JOIN products ON order_details.product_id = products.product_id\n" +
                " LIMIT ?, ?;";
        Object[] args = new Object[]{offset, limit};

        return this.jdbcTemplate.query(sql, args, new OrderResultSetExtractor());

    }

    @Override
    public List<Order> findByNameAndPrice(String name, BigDecimal price) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String getNameById(Long id) {
        return null;
    }
}
