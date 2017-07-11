package fruitbasket.com.java;

import java.util.HashMap;

/**
 * @author user
 *
 */
public class Basket {

	/**
	 * Map to hold Fruit type and its quantity in the basket
	 */
	private HashMap<FruitType, Integer> productsMap = new HashMap<FruitType, Integer>();

	/**
	 * Filed to hold total cart value
	 */
	private double totalPrice;

	/**
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return
	 */
	public HashMap<FruitType, Integer> getProductsMap() {
		return productsMap;
	}

	public void setProductsMap(HashMap<FruitType, Integer> productsMap) {
		this.productsMap = productsMap;
	}

	@Override
	public String toString() {
		return "Basket [productsMap=" + productsMap + ", totalPrice=" + totalPrice + "]";
	}

}
