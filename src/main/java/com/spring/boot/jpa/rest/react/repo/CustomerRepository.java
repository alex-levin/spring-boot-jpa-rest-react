package com.spring.boot.jpa.rest.react.repo;




import org.springframework.data.repository.Repository;

import com.spring.boot.jpa.rest.react.model.Customer;
import com.spring.boot.jpa.rest.react.model.EmailAddress;

/*
 * When extending the Repository marker interface directly, method implementations
 * are not automatically generated.
 * A class that implements this interface provides custom implementations.
 */
@org.springframework.stereotype.Repository
public interface CustomerRepository extends Repository<Customer, Long> {

	/**
	 * Returns the {@link Customer} with the given identifier.
	 * 
	 * @param id the id to search for.
	 * @return
	 */
	Customer findOne(Long id);

	/**
	 * Saves the given {@link Customer}.
	 * 
	 * @param customer the {@link Customer} to search for.
	 * @return
	 */
	Customer save(Customer customer);

	/**
	 * Returns the customer with the given {@link EmailAddress}.
	 * 
	 * @param emailAddress the {@link EmailAddress} to search for.
	 * @return
	 */
	Customer findByEmailAddress(EmailAddress emailAddress);
}
