package com.spring.boot.jpa.rest.react.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;

@Entity
public class LineItem extends AbstractEntity {

	private static final long serialVersionUID = 8430259688469973423L;

	@ManyToOne
	private Product product;

	@Column(nullable = false)
	private BigDecimal price;
	private int amount;

	/**
	 * Creates a new {@link LineItem} for the given {@link Product}.
	 * 
	 * @param product must not be {@literal null}.
	 */
	public LineItem(Product product) {
		this(product, 1);
	}

	/**
	 * Creates a new {@link LineItem} for the given {@link Product} and amount.
	 * 
	 * @param product must not be {@literal null}.
	 * @param amount
	 */
	public LineItem(Product product, int amount) {

		Assert.notNull(product, "The given Product must not be null!");
		Assert.isTrue(amount > 0, "The amount of Products to be bought must be greater than 0!");

		this.product = product;
		this.amount = amount;
		this.price = product.getPrice();
	}

	public LineItem() {

	}

	/**
	 * Returns the {@link Product} the {@link LineItem} refers to.
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Returns the amount of {@link Product}s to be ordered.
	 * 
	 * @return
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Returns the price a single unit of the {@link LineItem}'s product.
	 * 
	 * @return the price
	 */
	public BigDecimal getUnitPrice() {
		return price;
	}

	/**
	 * Returns the total for the {@link LineItem}.
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {
		return price.multiply(BigDecimal.valueOf(amount));
	}
}