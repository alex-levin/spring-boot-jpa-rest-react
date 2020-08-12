package com.spring.boot.jpa.rest.react.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
// "order" is reserved word in SQL ("order by")
@Table(name = "ORDERS")
public class Order extends AbstractEntity {

	private static final long serialVersionUID = 2817844639951464319L;

	@ManyToOne
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private Set<LineItem> lineItems = new HashSet<LineItem>();

	/**
	 * Creates a new {@link Order} for the given customer, shipping and billing {@link Address}.
	 * 
	 * @param customer must not be {@literal null}.
	 * @param shippingAddress must not be {@literal null}.
	 * @param billingAddress can be {@@iteral null}.
	 */
	public Order(Customer customer) {
		Assert.notNull(customer);
		this.customer = customer;
	}

	public Order() {

	}

	/**
	 * Adds the given {@link LineItem} to the {@link Order}.
	 * 
	 * @param lineItem
	 */
	public void add(LineItem lineItem) {
		this.lineItems.add(lineItem);
	}

	/**
	 * Returns the {@link Customer} who placed the {@link Order}.
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns all {@link LineItem}s currently belonging to the {@link Order}.
	 * 
	 * @return
	 */
	public Set<LineItem> getLineItems() {
		return Collections.unmodifiableSet(lineItems);
	}

	/**
	 * Returns the total of the {@link Order}.
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (LineItem item : lineItems) {
			total = total.add(item.getTotal());
		}

		return total;
	}
}