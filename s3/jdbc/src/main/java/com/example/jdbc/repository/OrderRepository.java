package com.example.jdbc.repository;

import com.example.jdbc.model.Order;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {
    int count();

    int save(Order order);

    int update(Order order);

    int deleteById(Long id);

    List<Order> findAll(int limit, int offset);

    List<Order> findByNameAndPrice(String name, BigDecimal price);

    Optional<Order> findById(Long id);

    String getNameById(Long id);
}
