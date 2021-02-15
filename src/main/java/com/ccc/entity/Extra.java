package com.ccc.entity;

/**
 * @author jorge Class that represent an extra
 */
public class Extra {

	/**
	 * The extra name
	 */
	private String name;

	/**
	 * The extra value
	 */
	private double value;

	public Extra(String name, double value) {
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
