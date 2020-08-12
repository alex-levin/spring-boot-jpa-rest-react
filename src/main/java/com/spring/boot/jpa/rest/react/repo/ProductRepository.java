package com.spring.boot.jpa.rest.react.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.jpa.rest.react.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	/**
	 * Returns a {@link Page} of {@link Product}s having a description which contains the given snippet.
	 * 
	 * @param description
	 * @param pageable
	 * @return
	 */
	Page<Product> findByDescriptionContaining(String description, Pageable pageable);

	/**
	 * Returns all {@link Product}s having the given attribute.
	 * 
	 * @param attribute
	 * @return
	 */
	@Query("select p from Product p where p.attributes[?1] = ?2")
	List<Product> findByAttributeAndValue(String attribute, String value);
}
