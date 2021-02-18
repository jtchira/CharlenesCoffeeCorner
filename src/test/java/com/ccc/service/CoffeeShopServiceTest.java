package com.ccc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ccc.entity.Coffee;
import com.ccc.entity.Customer;
import com.ccc.entity.Extra;
import com.ccc.entity.Juice;
import com.ccc.entity.Order;
import com.ccc.entity.Product;
import com.ccc.entity.Snack;
import com.ccc.entity.Util;

public class CoffeeShopServiceTest {
	
	
	private static Order order;

	@BeforeEach
	public void createOrder() {
		order = new Order();

		Extra milk = new Extra(Util.ADD_MILK, Util.ADD_MILK_VALUE);
		Coffee smallMilk = new Coffee(Util.SMALL_COFFEE, Util.SMALL_COFFEE_VALUE);
		smallMilk.setExtra(milk);

		Juice juice = new Juice(Util.ORANCE_JUICE, Util.ORANCE_JUICE_VALUE);
		Snack bacon = new Snack(Util.BACON_ROLL, Util.BACON_ROLL_VALUE);

		List<Product> products = new ArrayList<Product>();
		products.add(smallMilk);
		products.add(juice);
		products.add(bacon);

		order.setProducts(products);
//		order.setTotalDiscounts(Util.ADD_MILK_VALUE);
	}
	
	
	/**
	 * Test create order method
	 */
	@Test
	public void createOrderTest() {
		
		Order orderCreated = CoffeeShopService.createOrder("jorge", "small coffee , small coffee with milk , bacon roll , orange juice");
		assertNotEquals(orderCreated, null);
		
		Product smallCoffee = orderCreated.getProducts().get(0);
		assertEquals(smallCoffee.getName(), Util.SMALL_COFFEE);
		
		Product smallCoffeeMilk = orderCreated.getProducts().get(1);
		if(smallCoffeeMilk instanceof Coffee) {
			assertEquals(((Coffee)smallCoffeeMilk).getExtra().getName(),Util.ADD_MILK);
		}
		
		Product baconRoll = orderCreated.getProducts().get(2);
		assertEquals(baconRoll.getName(), Util.BACON_ROLL);
		
		Product orangejuice = orderCreated.getProducts().get(3);
		assertEquals(orangejuice.getName(), Util.ORANCE_JUICE);
		
	}

	/**
	 * Test the CoffeeShopService getFifthDiscount method
	 */
	@Test
	public void getFifthDiscountTest() {
		
		Customer customer = new Customer("jorge");
		customer.setAcumulatedBeverages(4);
		customer.setAcumulatedDiscounts(0);
		
		assertEquals(CoffeeShopService.getFifthDiscount(customer, order, 2), Util.SMALL_COFFEE_MILK_VALUE);
	}

	/**
	 * Test the CoffeeShopService getMenuDiscount method
	 */
	@Test
	public void getMenuDiscount() {
		
		assertEquals(CoffeeShopService.getMenuDiscount(order, 1), Util.ADD_MILK_VALUE); 
	}
	
	/**
	 * Test to evaluate the total value (with discounts) 
	 */
	@Test
	public void orderValueTest() {
		double result = Util.SMALL_COFFEE_VALUE + Util.MEDIUM_COFFEE_VALUE + Util.LARGE_COFFEE_VALUE + Util.ORANCE_JUICE_VALUE;
		Order orderCreated = CoffeeShopService.createOrder("alex", "small coffee , medium coffee , large coffee , orange juice , small coffee");
		orderCreated.getTotalProducts();
		orderCreated.getTotalDiscounts();
		assertEquals(result, orderCreated.calculateTotalOrder());
	}
	
	/**
	 * Test to evaluate the total value (with discounts) 
	 */
	@Test
	public void orderValueTest1() {
		double result = Util.SMALL_COFFEE_VALUE + Util.MEDIUM_COFFEE_VALUE + Util.LARGE_COFFEE_VALUE + Util.ORANCE_JUICE_VALUE + Util.BACON_ROLL_VALUE;
		Order orderCreated = CoffeeShopService.createOrder("diego", "small coffee , medium coffee , large coffee , orange juice , small coffee , bacon roll");
		orderCreated.getTotalProducts();
		orderCreated.getTotalDiscounts();
		assertEquals(result, orderCreated.calculateTotalOrder());
	}
	
	/**
	 * Test to evaluate the total value (with discounts) 
	 */
	@Test
	public void orderValueTest2() {
		double result = Util.SMALL_COFFEE_VALUE + Util.MEDIUM_COFFEE_VALUE + Util.LARGE_COFFEE_VALUE + Util.ORANCE_JUICE_VALUE + Util.SMALL_COFFEE_VALUE + Util.MEDIUM_COFFEE_VALUE + Util.LARGE_COFFEE_VALUE + Util.ORANCE_JUICE_VALUE ;
		Order orderCreated = CoffeeShopService.createOrder("brayan", "small coffee , medium coffee , large coffee , orange juice , orange juice , small coffee , medium coffee , large coffee , orange juice , orange juice");
		orderCreated.getTotalProducts();
		orderCreated.getTotalDiscounts();
		assertEquals(result, orderCreated.calculateTotalOrder());
	}
	
	/**
	 * Test to evaluate the total value (with discounts) 
	 */
	@Test
	public void orderValueTest3() {
		double result1 = Util.SMALL_COFFEE_VALUE + Util.MEDIUM_COFFEE_VALUE + Util.MEDIUM_COFFEE_VALUE;
		Order orderCreated1 = CoffeeShopService.createOrder("carlos", "small coffee , medium coffee , medium coffee");
		orderCreated1.getTotalProducts();
		orderCreated1.getTotalDiscounts();
		assertEquals(result1, orderCreated1.calculateTotalOrder());
		
		double result2 = Util.SMALL_COFFEE_VALUE + Util.LARGE_COFFEE_VALUE;
		Order orderCreated2 = CoffeeShopService.createOrder("carlos", "small coffee , medium coffee , large coffee");
		orderCreated2.getTotalProducts();
		orderCreated2.getTotalDiscounts();
		assertEquals(result2, orderCreated2.calculateTotalOrder());
	}
}