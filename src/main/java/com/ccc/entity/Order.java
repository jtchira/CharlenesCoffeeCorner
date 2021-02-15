package com.ccc.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jorge Class that represent a products order
 */
public class Order {

	/**
	 * Customer name that makes the order
	 */
	private String CustomerName;

	/**
	 * List products ordered
	 */
	private List<Product> products;

	/**
	 * Total order value, without applied any discount
	 */
	private double totalProducts;

	/**
	 * Total order discount to be applied
	 */
	private double totalDiscounts;

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	/**
	 * This method calculate the total product value
	 */
	public double getTotalProducts() {
		products.stream().forEach((p) -> totalProducts += p.getValue());
		return totalProducts;
	}

	public void setTotalProducts(double totalProducts) {
		this.totalProducts = totalProducts;
	}

	public double getTotalDiscounts() {
		return totalDiscounts;
	}

	public void setTotalDiscounts(double totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * This method get all the extras for all the products.
	 */
	public List<Extra> getExtras() {
		return products != null
				? products.stream().filter(p -> p instanceof Coffee).map(p -> (Coffee) p).map(c -> c.getExtra())
						.filter(e -> e != null).collect(Collectors.toList())
				: new ArrayList<Extra>();
	}

	/**
	 * This method get all the beverages in the order.
	 */
	public List<Product> getBeverages() {
		return products != null
				? products.stream().filter(p -> p instanceof Coffee || p instanceof Juice).collect(Collectors.toList())
				: new ArrayList<Product>();
	}

	/**
	 * This calculate the value with the discount applied.
	 */
	public double calculateTotalOrder() {
		return totalProducts - totalDiscounts;
	}

}
