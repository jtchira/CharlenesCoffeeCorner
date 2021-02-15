package com.ccc.entity;


/**
 * @author jorge
 * Class that represent a product
 */
public abstract class Product {
	
	
	/**
	 * Product name
	 */
	private String name;
	
	/**
	 * Product value
	 */
	private double value;
	
	public Product() {
		super();
	}
	public Product(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

}
