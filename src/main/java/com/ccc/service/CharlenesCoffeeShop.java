package com.ccc.service;

/**
 * @author jorge Main class to execute the program
 */
public class CharlenesCoffeeShop {

	public static void main(String args[]) {

		try {
			String orders[] = args[0].split(Util.ORDER_SPLIT);
			for (String order : orders) {
				String orderDetails[] = order.split(Util.CUSTOMER_SPLIT);
				if (orderDetails.length == 2) {
					CoffeeShopService.printReceipt(CoffeeShopService.createOrder(orderDetails[0].toLowerCase(),
							orderDetails[1].toLowerCase()));
				} else {
					System.out.println(Util.BAD_REQUEST);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(Util.BAD_REQUEST);
		}

	}

}
