package com.ccc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccc.entity.Coffee;
import com.ccc.entity.Customer;
import com.ccc.entity.Extra;
import com.ccc.entity.Juice;
import com.ccc.entity.Order;
import com.ccc.entity.Product;
import com.ccc.entity.Snack;

/**
 * @author jorge Class that has all the service that the coffee shop need
 */
public class CoffeeShopService {

	/**
	 * Constants to split the different request parts
	 */
	public static final String PRODUCT_SPLIT = " , ";
	public static final String EXTRA_SPLIT = " with ";
	public static final String CUSTOMER_SPLIT = " : ";
	public static final String ORDER_SPLIT = " ; ";
	public static final String EMPTY = "";

	public static final String BAD_REQUEST = "Bad Request";

	/**
	 * Constants with the different product values
	 */
	public static final double SMALL_COFFEE_VALUE = 2.50;
	public static final double MEDIUM_COFFEE_VALUE = 3.00;
	public static final double LARGE_COFFEE_VALUE = 3.50;
	public static final double BACON_ROLL_VALUE = 4.50;
	public static final double ORANCE_JUICE_VALUE = 3.95;
	public static final double ADD_MILK_VALUE = 0.30;
	public static final double ADD_FOAMED_MILK_VALUE = 0.50;
	public static final double ADD_SPECIAL_ROAST_VALUE = 0.90;

	/**
	 * Constants with the different product names
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
	public static final String SMALL_COFFEE_SPECIAL = "small coffee with special roast";
	public static final String MEDIUM_COFFEE_MILK = "medium coffee with milk";
	public static final String MEDIUM_COFFEE_FOAMED = "medium coffee with foamed milk";
	public static final String MEDIUM_COFFEE_SPECIAL = "medium coffee with special roast";
	public static final String LARGE_COFFEE_MILK = "large coffee with milk";
	public static final String LARGE_COFFEE_FOAMED = "large coffee with foamed milk";
	public static final String LARGE_COFFEE_SPECIAL = "large coffee with special roast";

	/**
	 * List with customers orders from the fifth beverage reward program
	 */
	private static Map<String, Customer> customers = new HashMap<String, Customer>();;

	public static void main(String args[]) {
		
		String orders[] = args[0].split(ORDER_SPLIT);
		if (args[0] == null || args[0] != null && EMPTY.equals(args[0].trim())) {
			System.out.println(BAD_REQUEST);
		} else {
			for (String order : orders) {
				String orderDetails[] = order.split(CUSTOMER_SPLIT);
				if (orderDetails.length == 2) {
					printReceipt(createOrder(orderDetails[0].toLowerCase(), orderDetails[1].toLowerCase()));
				} else {
					System.out.println(BAD_REQUEST);
				}
			}
		}
	}

	/**
	 * Method that process the customer request
	 */
	public static Order createOrder(String customerName, String pedido) {
		Order order = new Order();
		List<Product> orderProducts = new ArrayList<Product>();
		String[] products = pedido.split(PRODUCT_SPLIT);
		int countBeverage = 0;
		int countSnack = 0;
		for (String productName : products) {

			productName = productName.trim();
			String extraName = productName.contains(EXTRA_SPLIT)
					? productName.substring(productName.indexOf(EXTRA_SPLIT) + EXTRA_SPLIT.length())
					: EMPTY;
			productName = productName.contains(EXTRA_SPLIT) ? productName.substring(0, productName.indexOf(EXTRA_SPLIT))
					: productName;
			Extra extra = null;

			switch (extraName) {
			case ADD_MILK:
				extra = new Extra(ADD_MILK, ADD_MILK_VALUE);
				break;
			case ADD_FOAMED_MILK:
				extra = new Extra(ADD_FOAMED_MILK, ADD_FOAMED_MILK_VALUE);
				break;
			case ADD_SPECIAL_ROAST:
				extra = new Extra(ADD_SPECIAL_ROAST, ADD_SPECIAL_ROAST_VALUE);
				break;
			}

			Coffee coffee = null;

			switch (productName) {
			case SMALL_COFFEE:
				coffee = new Coffee(productName, SMALL_COFFEE_VALUE);
				coffee.setExtra(extra);
				orderProducts.add(coffee);
				countBeverage += 1;
				break;
			case MEDIUM_COFFEE:
				coffee = new Coffee(productName, MEDIUM_COFFEE_VALUE);
				coffee.setExtra(extra);
				orderProducts.add(coffee);
				countBeverage += 1;
				break;
			case LARGE_COFFEE:
				coffee = new Coffee(productName, LARGE_COFFEE_VALUE);
				coffee.setExtra(extra);
				orderProducts.add(coffee);
				countBeverage += 1;
				break;
			case BACON_ROLL:
				Snack snack = new Snack(productName, BACON_ROLL_VALUE);
				orderProducts.add(snack);
				countSnack += 1;
				break;
			case ORANCE_JUICE:
				Juice juice = new Juice(productName, ORANCE_JUICE_VALUE);
				orderProducts.add(juice);
				countBeverage += 1;
				break;
			default:
				return null;
			}

		}
		Customer customer = customers.get(customerName);
		if (customer == null) {
			customer = new Customer(customerName);
			customers.put(customerName, customer);
		}
		order.setProducts(orderProducts);

		order.setTotalDiscounts(getMenuDiscount(order, countSnack <= countBeverage ? countSnack : countBeverage)
				+ getFifthDiscount(customer, order, countBeverage));

		customers.put(customerName, customer);
		order.setCustomerName(customerName);
		return order;
	}

	/**
	 * Method that returns the fifth discount total value to be applied
	 */
	public static double getFifthDiscount(Customer customer, Order order, int orderedBeverages) {
		double discount = 0;

		int fifthDiscountToApply = ((customer.getAcumulatedBeverages() + orderedBeverages)
				- customer.getAcumulatedDiscounts()) / 5;

		for (int cont = 0; cont < fifthDiscountToApply; cont++) {
			customer.setAcumulatedDiscounts(customer.getAcumulatedDiscounts() + 1);
			int positionDiscount = customer.getAcumulatedDiscounts() * 5;
			int positionBeverage = positionDiscount - customer.getAcumulatedBeverages() - 1;
			discount += order.getBeverages().get(positionBeverage).getValue();
		}
		order.getBeverages();

		customer.setAcumulatedBeverages(customer.getAcumulatedBeverages() + orderedBeverages);
		return discount;
	}

	/**
	 * Method that returns the discount to be applied for each beverage snack menu
	 */
	public static double getMenuDiscount(Order order, int discountToApply) {
		double discount = 0;

		for (int cont = 0; cont < order.getExtras().size() && discountToApply > 0; cont++, discountToApply--) {
			discount += order.getExtras().get(cont).getValue();
		}
		return discount;
	}

	/**
	 * Method to print in console the receipt
	 */
	public static void printReceipt(Order order) {
		if (order != null) {
			System.out.println("********* Customer name    " + order.getCustomerName() + "  ************");
			order.getProducts().stream().forEach((p) -> {
				System.out.println(p.getName() + "  " + p.getValue());
			});
			System.out.println("total products    " + order.getTotalProducts());
			System.out.println("total discount    " + order.getTotalDiscounts());
			System.out.println("total to pay      " + order.calculateTotalOrder());
			System.out.println("**********************************************");
		} else {
			System.out.println(BAD_REQUEST);
		}
	}
}
