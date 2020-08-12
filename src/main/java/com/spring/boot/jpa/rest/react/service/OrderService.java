package com.spring.boot.jpa.rest.react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.rest.react.model.Customer;
import com.spring.boot.jpa.rest.react.model.Order;
import com.spring.boot.jpa.rest.react.repo.OrderRepository;

@Service
public class OrderService {

	private OrderRepository repository;
	
	@Autowired
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}
	
	public List<Order> findByCustomer(Customer customer) {
		return repository.findByCustomer(customer);
	}
}
