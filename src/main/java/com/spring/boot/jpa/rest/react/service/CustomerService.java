package com.spring.boot.jpa.rest.react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.rest.react.model.Customer;
import com.spring.boot.jpa.rest.react.model.EmailAddress;
import com.spring.boot.jpa.rest.react.repo.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;
	
	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	public Customer findOne(Long id) {
		return repository.findOne(id);
	}

	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	public Customer findByEmailAddress(EmailAddress emailAddress) {
		return repository.findByEmailAddress(emailAddress);
	}
}
