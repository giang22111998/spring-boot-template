package com.example.jdbc;

import com.example.jdbc.model.Order;
import com.example.jdbc.repository.OrderRepository;
import com.example.jdbc.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(JdbcApplication.class);

	@Autowired
	@Qualifier("JdbcOrderRepositoryImpl")
	private OrderRepository orderRepository;

	@Autowired(required = false)
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Running JdbcApplication...");
		int count = orderRepository.count();
		logger.info("Order count: " + count);

		List<Order> orders = orderRepository.findAll(10,0);

		logger.info("Found: %s orders" + orders.size());
		if (orders.size() > 0) {
			logger.info("Order 0: " + orders.get(0).getOrderId());
		}

	}
}
