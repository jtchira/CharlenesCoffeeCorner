package com.ccc.entity;

public abstract class Util {
	
	
	/**
	 * Constants to split the different request parts
	 */
	public static final String PRODUCT_SPLIT = " , ";
	public static final String EXTRA_PREFIX = " with ";
	public static final String CUSTOMER_SPLIT = ": ";

	/**
	 * Constants with product values
	 */
	public static final double SMALL_COFFEE_VALUE = 2.50;
	public static final double MEDIUM_COFFEE_VALUE = 3.00;
	public static final double LARGE_COFFEE_VALUE = 3.50;
	public static final double BACON_ROLL_VALUE = 4.50;
	public static final double ORANCE_JUICE_VALUE = 3.95;
	public static final double ADD_MILK_VALUE = 0.30;
	public static final double ADD_FOAMED_MILK_VALUE = 0.50;
	public static final double ADD_SPECIAL_ROAST_VALUE = 0.90;
	public static final double SMALL_COFFEE_MILK_VALUE = SMALL_COFFEE_VALUE + ADD_MILK_VALUE;
	public static final double SMALL_COFFEE_FOAMED_VALUE = SMALL_COFFEE_VALUE + ADD_FOAMED_MILK_VALUE;
	public static final double SMALL_COFFEE_SPECIAL_VALUE= SMALL_COFFEE_VALUE + ADD_SPECIAL_ROAST_VALUE;
	public static final double MEDIUM_COFFEE_MILK_VALUE = MEDIUM_COFFEE_VALUE + ADD_MILK_VALUE;
	public static final double MEDIUM_COFFEE_FOAMED_VALUE = MEDIUM_COFFEE_VALUE + ADD_FOAMED_MILK_VALUE;
	public static final double MEDIUM_COFFEE_SPECIAL_VALUE= MEDIUM_COFFEE_VALUE + ADD_SPECIAL_ROAST_VALUE;
	public static final double LARGE_COFFEE_MILK_VALUE = LARGE_COFFEE_VALUE + ADD_MILK_VALUE;
	public static final double LARGE_COFFEE_FOAMED_VALUE = LARGE_COFFEE_VALUE + ADD_FOAMED_MILK_VALUE;
	public static final double LARGE_COFFEE_SPECIAL_VALUE= LARGE_COFFEE_VALUE + ADD_SPECIAL_ROAST_VALUE;

	/**
	 * Constants with product names
	 */
	public static final String SMALL_COFFEE = "small coffee";
	public static final String MEDIUM_COFFEE = "medium coffee";
	public static final String LARGE_COFFEE = "large coffee";
	public static final String BACON_ROLL = "bacon roll";
	public static final String ORANCE_JUICE = "orange juice";
	public static final String ADD_MILK = "milk";
	public static final String ADD_FOAMED_MILK = "foamed milk";
	public static final String ADD_SPECIAL_ROAST = "special roast";
	public static final String SMALL_COFFEE_MILK = "small coffee with milk";
	public static final String SMALL_COFFEE_FOAMED = "small coffee with foamed milk";
	public static final String SMALL_COFFEE_SPECIAL= "small coffee with special roast";
	public static final String MEDIUM_COFFEE_MILK = "medium coffee with milk";
	public static final String MEDIUM_COFFEE_FOAMED = "medium coffee with foamed milk";
	public static final String MEDIUM_COFFEE_SPECIAL= "medium coffee with special roast";
	public static final String LARGE_COFFEE_MILK = "large coffee with milk";
	public static final String LARGE_COFFEE_FOAMED = "large coffee with foamed milk";
	public static final String LARGE_COFFEE_SPECIAL= "large coffee with special roast";

}
