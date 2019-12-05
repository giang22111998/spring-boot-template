package com.example.jdbc.repository;

import com.example.jdbc.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    int count();

    int save(Product product);

    int update(Product product);

    int deleteById(Integer id);

    List<Product> findAll(Integer limit, Integer offset);

    List<Product> findByName(String name);

    Optional<Product> findById(Integer id);

    String getNameById(Integer id);
}
