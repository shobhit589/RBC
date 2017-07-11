package fruitbasket.com.java;
/*
* Shopping items with type and quantity
*
*/

public class Fruit {

	/**
	 * Quantity of a fruit
	 */
	private int quantity;
	/**
	 * Name of Fruit
	 */
	private FruitType item;

	/**
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	public Fruit(FruitType item) {
		super();
		this.item = item;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Fruit(int quantity, FruitType item) {
		super();
		this.quantity = quantity;
		this.item = item;
	}

	/**
	 * @return
	 */
	public FruitType getItem() {
		return item;
	}

	/**
	 * @param item
	 */
	public void setItem(FruitType item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Fruit [quantity=" + quantity + ", item=" + item + "]";
	}

}
