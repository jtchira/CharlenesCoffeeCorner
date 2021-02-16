package com.ccc.service;

import com.ccc.entity.Extra;

/**
 * @author jorge
 * Enum with the available extras
 */
public enum ExtraItem {
	
	MILK("milk", 0.30),
	FOAMED_MILK("foamed milk", 0.50),
	SPECIAL_ROAST ("special roast", 0.90);
	
	/**
	 * ExtraItem name
	 */
	private final String name;
	/**
	 * ExtraItem value
	 */
	private final double value;
	
	private ExtraItem(String name, double value) {
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
	 * Method to create an extra
	 */
	public Extra createExtra() {
		return new Extra(getName(), getValue());
	}
}
