package com.ccc.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jorge Order test class
 */
public class OrderTest {

	private static Order order;

	@BeforeEach
	public void createOrder() {
		order = new Order();
		order.setCustomerName("jorge");

		Extra milk = new Extra(Util.ADD_MILK, Util.ADD_MILK_VALUE);

		Coffee small = new Coffee(Util.SMALL_COFFEE, Util.SMALL_COFFEE_VALUE);
		Coffee smallMilk = new Coffee(Util.SMALL_COFFEE, Util.SMALL_COFFEE_VALUE);
		smallMilk.setExtra(milk);

		Juice juice = new Juice(Util.ORANCE_JUICE, Util.ORANCE_JUICE_VALUE);
		Snack bacon = new Snack(Util.BACON_ROLL, Util.BACON_ROLL_VALUE);

		List<Product> products = new ArrayList<Product>();
		products.add(small);
		products.add(smallMilk);
		products.add(juice);
		products.add(bacon);

		order.setProducts(products);
		order.setTotalDiscounts(Util.ADD_MILK_VALUE);
	}

	@AfterEach
	public void resetValues() {
		order = null;
	}

	/**
	 * This test calculate the total product value
	 */
	@Test
	public void getTotalProductsTest() {
		double total = Util.SMALL_COFFEE_MILK_VALUE + Util.SMALL_COFFEE_VALUE + Util.ORANCE_JUICE_VALUE
				+ Util.BACON_ROLL_VALUE;
		assertTrue(total == order.getTotalProducts());

	}

	/**
	 * This test get all the extras for all the products.
	 */
	@Test
	public void getExtrasTest() {
		assertEquals(order.getExtras().size(), 1);
	}

	/**
	 * This test get all the beverages in the order.
	 */
	@Test
	public void getBeveragesTest() {
		assertEquals(order.getBeverages().size(), 3);
	}

	/**
	 * This test calculate the value with the discount applied.
	 */
	@Test
	public void calculateTotalOrderTest() {
		double total = Util.SMALL_COFFEE_MILK_VALUE + Util.SMALL_COFFEE_VALUE + Util.ORANCE_JUICE_VALUE
				+ Util.BACON_ROLL_VALUE - Util.ADD_MILK_VALUE;
		order.getTotalProducts();
		assertTrue(total == order.calculateTotalOrder());

	}

}
