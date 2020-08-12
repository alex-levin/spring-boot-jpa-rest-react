package com.spring.boot.jpa.rest.react.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.jpa.rest.react.model.Customer;
import com.spring.boot.jpa.rest.react.model.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

	/**
	 * Returns all {@link Order}s of the given {@link Customer}.
	 * 
	 * @param customer
	 * @return
	 */
	List<Order> findByCustomer(Customer customer);
}