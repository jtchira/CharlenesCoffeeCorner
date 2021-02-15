package com.ccc.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * @author jorge
 * Class to test the coffee methods
 */
public class CoffeeTest {

	private static List<Coffee> coffeeList;

	@BeforeAll
	public static void createCoffeeList() {
		System.out.println("entro");
		coffeeList = new ArrayList<Coffee>();

		Extra milk = new Extra(Util.ADD_MILK, Util.ADD_MILK_VALUE);
		Extra foamed = new Extra(Util.ADD_FOAMED_MILK, Util.ADD_FOAMED_MILK_VALUE);
		Extra special = new Extra(Util.ADD_SPECIAL_ROAST, Util.ADD_SPECIAL_ROAST_VALUE);

		Coffee small = new Coffee(Util.SMALL_COFFEE, Util.SMALL_COFFEE_VALUE);
		coffeeList.add(small);
		Coffee medium = new Coffee(Util.MEDIUM_COFFEE, Util.MEDIUM_COFFEE_VALUE);
		coffeeList.add(medium);
		Coffee large = new Coffee(Util.LARGE_COFFEE, Util.LARGE_COFFEE_VALUE);
		coffeeList.add(large);

		Coffee smallMilk = new Coffee(Util.SMALL_COFFEE_MILK, Util.SMALL_COFFEE_VALUE);
		smallMilk.setExtra(milk);
		coffeeList.add(smallMilk);
		Coffee smallFoamed = new Coffee(Util.SMALL_COFFEE_FOAMED, Util.SMALL_COFFEE_VALUE);
		smallFoamed.setExtra(foamed);
		coffeeList.add(smallFoamed);
		Coffee smallSpecial = new Coffee(Util.SMALL_COFFEE_SPECIAL, Util.SMALL_COFFEE_VALUE);
		smallSpecial.setExtra(special);
		coffeeList.add(smallSpecial);

		Coffee mediumMilk = new Coffee(Util.MEDIUM_COFFEE_MILK, Util.MEDIUM_COFFEE_VALUE);
		mediumMilk.setExtra(milk);
		coffeeList.add(mediumMilk);
		Coffee mediumFoamed = new Coffee(Util.MEDIUM_COFFEE_FOAMED, Util.MEDIUM_COFFEE_VALUE);
		mediumFoamed.setExtra(foamed);
		coffeeList.add(mediumFoamed);
		Coffee mediumSpecial = new Coffee(Util.MEDIUM_COFFEE_SPECIAL, Util.MEDIUM_COFFEE_VALUE);
		mediumSpecial.setExtra(special);
		coffeeList.add(mediumSpecial);

		Coffee largeMilk = new Coffee(Util.LARGE_COFFEE_MILK, Util.LARGE_COFFEE_VALUE);
		largeMilk.setExtra(milk);
		coffeeList.add(largeMilk);
		Coffee largeFoamed = new Coffee(Util.LARGE_COFFEE_FOAMED, Util.LARGE_COFFEE_VALUE);
		largeFoamed.setExtra(foamed);
		coffeeList.add(largeFoamed);
		Coffee largeSpecial = new Coffee(Util.LARGE_COFFEE_SPECIAL, Util.LARGE_COFFEE_VALUE);
		largeSpecial.setExtra(special);
		coffeeList.add(largeSpecial);
	}

	@Test
	public void calculateCoffeeValueTest() {
		boolean rigthValues = true;
		for (Coffee coffee : coffeeList) {
			switch (coffee.getName()) {
			case Util.SMALL_COFFEE:
				if (coffee.getValue() != Util.SMALL_COFFEE_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.MEDIUM_COFFEE:
				if (coffee.getValue() != Util.MEDIUM_COFFEE_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.LARGE_COFFEE:
				if (coffee.getValue() != Util.LARGE_COFFEE_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.SMALL_COFFEE_MILK:
				if (coffee.getValue() != Util.SMALL_COFFEE_MILK_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.SMALL_COFFEE_FOAMED:
				if (coffee.getValue() != Util.SMALL_COFFEE_FOAMED_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.SMALL_COFFEE_SPECIAL:
				if (coffee.getValue() != Util.SMALL_COFFEE_SPECIAL_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.MEDIUM_COFFEE_MILK:
				if (coffee.getValue() != Util.MEDIUM_COFFEE_MILK_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.MEDIUM_COFFEE_FOAMED:
				if (coffee.getValue() != Util.MEDIUM_COFFEE_FOAMED_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.MEDIUM_COFFEE_SPECIAL:
				if (coffee.getValue() != Util.MEDIUM_COFFEE_SPECIAL_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.LARGE_COFFEE_MILK:
				if (coffee.getValue() != Util.LARGE_COFFEE_MILK_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.LARGE_COFFEE_FOAMED:
				if (coffee.getValue() != Util.LARGE_COFFEE_FOAMED_VALUE) {
					rigthValues = false;
				}
				break;
			case Util.LARGE_COFFEE_SPECIAL:
				if (coffee.getValue() != Util.LARGE_COFFEE_SPECIAL_VALUE) {
					rigthValues = false;
				}
				break;

			}
			assertTrue(rigthValues);
		}

	}

}
