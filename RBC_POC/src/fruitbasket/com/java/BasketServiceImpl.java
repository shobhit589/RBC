package fruitbasket.com.java;

import java.util.Map;

/**
 * @author user
 *
 */
public class BasketServiceImpl implements BasketService {

	private final Basket basket;

	public BasketServiceImpl(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void addFruit(Fruit fruit) throws BasketException {
		if (validateFruit(fruit)) {
			basket.getProductsMap().put(fruit.getItem(), fruit.getQuantity());
			calculateBasketPrice(basket);// update the total price in basket
											// after addition of items.
		}
	}

	/*
	 * This method will remove all the quantity of fruit passed from the basket,
	 * if it is in the basket.
	 */
	@Override
	public void removeFruit(Fruit fruit) throws BasketException {
		if (isBasketEmpty(basket)) {
			throw new BasketException(" Can not remove items from basket as it is already empty ");
		}
		if (null == fruit || null == fruit.getItem()) {
			throw new BasketException("Can not remove fruit, Invalid fruit name for fruit to be removed");
		}
		if (basket.getProductsMap().containsKey(fruit.getItem())) {
			basket.getProductsMap().remove(fruit.getItem());
			calculateBasketPrice(basket);
		} else {
			throw new BasketException(" Can not remove items from basket as it is not present in basket");
		}
	}

	@Override
	public double calculateBasketPrice(Basket basket) {
		double totalPrice = 0.0;
		if (!isBasketEmpty(basket)) {
			for (Map.Entry<FruitType, Integer> pair : basket.getProductsMap().entrySet()) {
				totalPrice += pair.getKey().getPricePerPiece() * pair.getValue();
			}
		}
		basket.setTotalPrice(totalPrice);// set total price in basket as well.s
		return totalPrice;
	}

	@Override
	public void viewBasket(Basket basket) {

		basket.getProductsMap().entrySet().stream()
				.forEach(e -> System.out.println("Fruit name : " + e.getKey() + " Quantity : " + e.getValue()));
		System.out.println("Total Price == " + calculateBasketPrice(basket));
	}

	private boolean isBasketEmpty(Basket basket) {
		return (null == basket || null == basket.getProductsMap() || basket.getProductsMap().isEmpty());
	}

	@Override
	public void increseQuantity(Fruit fruit) throws BasketException {
		if (validateFruit(fruit)) {
			if (basket.getProductsMap().containsKey(fruit.getItem())) {
				Integer initialQuantity = (Integer) basket.getProductsMap().get(fruit.getItem());
				basket.getProductsMap().put(fruit.getItem(), initialQuantity + fruit.getQuantity());
				calculateBasketPrice(basket);
			} else {
				throw new BasketException("Can not increase quantity for this item as it is not present in basket");
			}

		}

	}

	@Override
	public void decreaseQuantity(Fruit fruit) throws BasketException {
		if (validateFruit(fruit)) {
			if (basket.getProductsMap().containsKey(fruit.getItem())) {
				Integer initialQuantity = (Integer) basket.getProductsMap().get(fruit.getItem());
				Integer updatedQuantity = initialQuantity - fruit.getQuantity();
				if (updatedQuantity >= 0) {
					basket.getProductsMap().put(fruit.getItem(), updatedQuantity);
					calculateBasketPrice(basket);
				} else
					throw new BasketException("Not sufficient fruit in basket to decrease quantity to this amount");
			} else {
				throw new BasketException(" Can not  decrease quantit for this item as it is not present in basket");
			}
		}
	}

	private boolean validateFruit(Fruit fruit) throws BasketException {
		if (null == fruit || null == fruit.getItem()) {
			throw new BasketException(" Fruit can not be null, Please add a valid fruit ");
		}
		if (fruit.getQuantity() <= 0) {
			throw new BasketException(
					" Quntity of fruit can not be equal to or less than 0, Please add a valid quantity ");
		}
		return true;
	}

}
