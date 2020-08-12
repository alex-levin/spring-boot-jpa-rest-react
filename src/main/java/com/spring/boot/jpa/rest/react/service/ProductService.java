package com.spring.boot.jpa.rest.react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.rest.react.model.Product;
import com.spring.boot.jpa.rest.react.repo.ProductRepository;

@Service
public class ProductService {
	private ProductRepository repository;
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public Page<Product> findByDescriptionContaining(String description, Pageable pageable) {
		return repository.findByDescriptionContaining(description, pageable);
	}
	
	public List<Product> findByAttributeAndValue(String attribute, String value) {
		return repository.findByAttributeAndValue(attribute, value);
	}

}
