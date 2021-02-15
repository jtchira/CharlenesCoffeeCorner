package com.ccc.entity;

/**
 * @author jorge Class that represent a customer order
 */
public class Customer {

	/**
	 * Customer name
	 */
	private String name;
	
	/**
	 * All orders accumulated beverages
	 */
	private int acumulatedBeverages;
	
	/**
	 * All orders accumulated fifth beverage discounts
	 */
	private int acumulatedDiscounts;

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAcumulatedBeverages() {
		return acumulatedBeverages;
	}

	public void setAcumulatedBeverages(int acumulatedBeverages) {
		this.acumulatedBeverages = acumulatedBeverages;
	}

	public int getAcumulatedDiscounts() {
		return acumulatedDiscounts;
	}

	public void setAcumulatedDiscounts(int acumulatedDiscounts) {
		this.acumulatedDiscounts = acumulatedDiscounts;
	}

}
