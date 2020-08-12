package com.spring.boot.jpa.rest.react.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.spring.boot.jpa.rest.react.model.Customer;
import com.spring.boot.jpa.rest.react.model.EmailAddress;

@Repository
class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext // (unitName = "storedb")
	private EntityManager em;

	/* 
	 * (non-Javadoc)
	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#findOne(java.lang.Long)
	 */
	@Override
	public Customer findOne(Long id) {
		return em.find(Customer.class, id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#save(com.oreilly.springdata.jpa.core.Customer)
	 */
	@Transactional // (value = "txMain", propagation = Propagation.REQUIRES_NEW)
	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			em.persist(customer);
			return customer;
		} else {
			return em.merge(customer);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#findByEmailAddress(com.oreilly.springdata.jpa.core.EmailAddress)
	 */
	@Override
	public Customer findByEmailAddress(EmailAddress emailAddress) {

		TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.emailAddress = :email",
				Customer.class);
		query.setParameter("email", emailAddress);

		return query.getSingleResult();
	}
}