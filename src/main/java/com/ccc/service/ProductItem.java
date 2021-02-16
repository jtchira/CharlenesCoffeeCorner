package com.ccc.service;

import java.util.List;

import com.ccc.entity.Coffee;
import com.ccc.entity.Extra;
import com.ccc.entity.Juice;
import com.ccc.entity.Product;
import com.ccc.entity.Snack;

/**
 * @author jorge
 * Enum that represents the available products available
 */
public enum ProductItem {
	
	SMALL_COFFEE("small coffee", 2.50) { @Override public void createProduct(Extra extra, List<Product> orderProducts) {
		createCoffee(extra, orderProducts);
	} },
	MEDIUM_COFFEE("medium coffee", 3.00) { @Override public void createProduct(Extra extra, List<Product> orderProducts) {
		createCoffee(extra, orderProducts);
	} },
	LARGE_COFFEE ("large coffee", 3.50) { @Override public void createProduct(Extra extra, List<Product> orderProducts) {
		createCoffee(extra, orderProducts);
	} },
	BACON_ROLL("bacon roll", 4.50) { @Override public void createProduct(Extra extra, List<Product> orderProducts) { 
		Snack snack = new Snack(getName(), getValue());
		orderProducts.add(snack);
	} },
	ORANGE_JUICE("orange juice", 3.95) { @Override public void createProduct(Extra extra, List<Product> orderProducts) {
		Juice juice = new Juice(getName(), getValue());
		orderProducts.add(juice);
	} };
	
	/**
	 * ProductItem name
	 */
	private final String name;
	/**
	 * ProductItem value
	 */
	private final double value;
	
	private ProductItem(String name, double value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public double getValue() {
		return value;
	}
	
	
	/**
	 * Generic method to create a product and add it to the order
	 */
	public abstract void createProduct(Extra extra, List<Product> orderProducts);
	
	/**
	 * Specialized method to create a coffee and add it to the order
	 */
	public void createCoffee(Extra extra, List<Product> orderProducts) {
		Coffee coffee = new Coffee(getName(), getValue());
		coffee.setExtra(extra);
		orderProducts.add(coffee);
	}
}
