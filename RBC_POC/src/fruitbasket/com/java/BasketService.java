package fruitbasket.com.java;

/**
 * @author user
 *
 */
public interface BasketService {

	/**
	 * API is used to add a fruit in the basket and also verify the added fruit.
	 * 
	 * @param Fruit
	 * @throws BasketException
	 */
	public void addFruit(Fruit fruit) throws BasketException;

	/**
	 * This method will remove all the quantity of fruit passed from the basket,
	 * if it is in the basket.
	 * 
	 * @param Fruit
	 * @throws BasketException
	 */
	public void removeFruit(Fruit fruit) throws BasketException;

	/**
	 * * API is used to calculate the total value of all the items present in
	 * the basket.
	 * 
	 * @return
	 */
	public double calculateBasketPrice(Basket basket);

	/**
	 * * API is used to increase the quantity of any fruit which is already
	 * present in the basket.
	 * 
	 * @param fruit
	 * @throws BasketException
	 */
	public void increseQuantity(Fruit fruit) throws BasketException;

	/**
	 * API is used to decrease the quantity of any fruit which is already
	 * present in the basket. Also verify that decreasing quantity should not
	 * make it negative value
	 * 
	 * @param fruit
	 * @throws BasketException
	 */
	public void decreaseQuantity(Fruit fruit) throws BasketException;

	/**
	 * Method to Print Basket contents and its value
	 * 
	 * @param basket
	 * @return
	 * @throws BasketException
	 */
	public void viewBasket(Basket basket);

}
