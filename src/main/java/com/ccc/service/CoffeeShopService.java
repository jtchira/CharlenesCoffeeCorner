package com.ccc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccc.entity.Customer;
import com.ccc.entity.Extra;
import com.ccc.entity.Order;
import com.ccc.entity.Product;

/**
 * @author jorge Class that has all the service that the coffee shop need
 */
public class CoffeeShopService {



	/**
	 * List with customers orders from the fifth beverage reward program
	 */
	private static Map<String, Customer> customers = new HashMap<String, Customer>();

	/**
	 * Method that process the customer request
	 */
	public static Order createOrder(String customerName, String pedido) {
		Order order = new Order();
		List<Product> orderProducts = new ArrayList<Product>();
		String[] products = pedido.split(Util.PRODUCT_SPLIT);
		
		for (String productName : products) {

			productName = productName.trim();
			String extraName = productName.contains(Util.EXTRA_SPLIT)
					? productName.substring(productName.indexOf(Util.EXTRA_SPLIT) + Util.EXTRA_SPLIT.length())
					: Util.EMPTY;
			productName = productName.contains(Util.EXTRA_SPLIT) ? productName.substring(0, productName.indexOf(Util.EXTRA_SPLIT))
					: productName;

			try {
				Extra extra = null;
				if (!Util.EMPTY.equals(extraName)) {
					ExtraItem extraItem = ExtraItem.valueOf(extraName.toUpperCase().replace(Util.SPACE, Util.UNDERSCORE));
					extra = extraItem.createExtra();
				}

				ProductItem productItem = ProductItem.valueOf(productName.toUpperCase().replace(Util.SPACE, Util.UNDERSCORE));
				productItem.createProduct(extra, orderProducts);
			} catch (IllegalArgumentException e) {
				System.out.println(Util.BAD_REQUEST);
				System.out.println(e);
			}

		}
		Customer customer = customers.get(customerName);
		if (customer == null) {
			customer = new Customer(customerName);
			customers.put(customerName, customer);
		}
		order.setProducts(orderProducts);

		int beverages = order.getBeverages().size();
		int snacks = order.getBeverages().size();
		order.setTotalDiscounts(getMenuDiscount(order, snacks <= beverages ? snacks : beverages)
				+ getFifthDiscount(customer, order, beverages));

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
			System.out.println(Util.BAD_REQUEST);
		}
	}
}
