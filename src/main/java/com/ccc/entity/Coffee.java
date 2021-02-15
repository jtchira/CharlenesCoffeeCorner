package com.ccc.entity;

/**
 * @author jorge
 * Class that represent a coffee
 */
public class Coffee extends Product {

	/**
	 * If the coffee has an extra
	 */
	private Extra extra;


	public Coffee(String name, double value) {
		super(name, value);
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	/**
	 * The original behavior was modified to consider the extra value if applied.
	 */
	public double getValue() {
		return extra == null ? super.getValue() : super.getValue() + extra.getValue();

	}

}
