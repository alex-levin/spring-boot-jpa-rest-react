package com.spring.boot.jpa.rest.react.repo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.jpa.rest.react.model.Address;
import com.spring.boot.jpa.rest.react.model.Customer;
import com.spring.boot.jpa.rest.react.model.EmailAddress;
import com.spring.boot.jpa.rest.react.model.LineItem;
import com.spring.boot.jpa.rest.react.model.Order;
import com.spring.boot.jpa.rest.react.model.Product;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	@Autowired
	public DatabaseLoader(CustomerRepository customerRepository, OrderRepository orderRepository,
			ProductRepository productRepository) {
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		Customer customer1 = new Customer("Alex", "Levin");
		Address address1 = new Address("1 Washington St.", "Boston", "United States");
		Address address2 = new Address("20 Sunset St.", "Toronto", "Canada");
		EmailAddress emailAddress1 = new EmailAddress("alex@mail.com");
		customer1.add(address1);
		customer1.add(address2);
		customer1.setEmailAddress(emailAddress1);
		
		Product product1 = new Product("Garden Hose", new BigDecimal("16.99"));
		product1.setAttribute("Length", "6 Feet");
		Product product2 = new Product("Strap Wrench", new BigDecimal("11.29"));
		product2.setAttribute("Manufacturer", "Husky");
		
		LineItem lineItem1 = new LineItem(product1);
		LineItem lineItem2 = new LineItem(product2, 2);
		
		Order order1 = new Order(customer1);
		order1.add(lineItem1);
		order1.add(lineItem2);	
		
		customerRepository.save(customer1);
		productRepository.save(product1);
		productRepository.save(product2);
		orderRepository.save(order1);
	}
}
