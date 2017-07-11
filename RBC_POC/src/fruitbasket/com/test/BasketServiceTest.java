package fruitbasket.com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fruitbasket.com.java.Basket;
import fruitbasket.com.java.BasketException;
import fruitbasket.com.java.BasketService;
import fruitbasket.com.java.BasketServiceImpl;
import fruitbasket.com.java.Fruit;
import fruitbasket.com.java.FruitType;

/**
 * Test Class to test BookService API, not using mockito i was not sure if it
 * has to be used.
 * 
 * @author user
 *
 *
 */
public class BasketServiceTest {

	BasketService basketService;
	Fruit fruit;
	Basket basket;

	@Before
	public void initialize() {
		basket = new Basket();
		basketService = new BasketServiceImpl(basket);
	}

	@Test(expected = BasketException.class)
	public void testAddFruitwithNullFruit() throws BasketException {
		Fruit fruit = null;
		basketService.addFruit(fruit);
	}

	@Test(expected = BasketException.class)
	public void testAddFruitwithNullFruitType() throws BasketException {
		Fruit fruit = new Fruit(1, null);
		basketService.addFruit(fruit);
	}

	@Test(expected = BasketException.class)
	public void testAddFruitwithFruitNegaiveQuantity() throws BasketException {
		Fruit fruit = new Fruit(-1, FruitType.APPLE);
		basketService.addFruit(fruit);
	}

	@Test
	public void testAddFruitwithValidFruit() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		assertEquals(1, basket.getProductsMap().size());
	}

	@Test
	public void testRemoveFruitwithValidFruit() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		Fruit removeFruit = new Fruit(FruitType.APPLE);
		basketService.removeFruit(removeFruit);
		assertEquals(0, basket.getProductsMap().size());
	}

	/**
	 * test for removing fruit which is not present in the basket
	 * 
	 * @throws BasketException
	 */
	@Test(expected = BasketException.class)
	public void testRemoveFruitwithInValidFruit() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		Fruit removeFruit = new Fruit(FruitType.ORANGE);
		basketService.removeFruit(removeFruit);
	}

	@Test(expected = BasketException.class)
	public void testRemoveFruitwithNullFruitType() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		Fruit removeFruit = new Fruit(null);
		basketService.removeFruit(removeFruit);
	}

	/**
	 * test for removing fruit from an empty basket
	 * 
	 * @throws BasketException
	 */
	@Test(expected = BasketException.class)
	public void testRemoveFruitFromEmptyBasket() throws BasketException {
		Fruit removeFruit = new Fruit(FruitType.ORANGE);
		basketService.removeFruit(removeFruit);
	}

	@Test
	public void testCalculateCartPrice() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		basketService.addFruit(new Fruit(10, FruitType.LEMON));
		assertTrue(215 == basketService.calculateBasketPrice(basket));
	}

	@Test
	public void testIncreaseQuantityWithValid() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		basketService.increseQuantity(new Fruit(10, FruitType.APPLE));
		assertTrue(14 == (Integer) basket.getProductsMap().get(FruitType.APPLE));
	}

	/**
	 * Trying to increase the quantity of a fruit which is not present in the
	 * basket
	 * 
	 * @throws BasketException
	 */
	@Test(expected = BasketException.class)
	public void testIncreaseQuantityWithInValid() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		basketService.increseQuantity(new Fruit(10, FruitType.ORANGE));
	}

	@Test
	public void testDecreaseQuantityWithValid() throws BasketException {
		basketService.addFruit(new Fruit(10, FruitType.APPLE));
		basketService.decreaseQuantity(new Fruit(4, FruitType.APPLE));
		assertTrue(6 == (Integer) basket.getProductsMap().get(FruitType.APPLE));
	}

	/**
	 * Trying to decrease the quantity of a fruit which is not present in the
	 * basket
	 * 
	 * @throws BasketException
	 */
	@Test(expected = BasketException.class)
	public void testDecreaseQuantityWithInValid() throws BasketException {
		basketService.addFruit(new Fruit(10, FruitType.APPLE));
		basketService.decreaseQuantity(new Fruit(4, FruitType.ORANGE));
	}

	/**
	 * Trying to decrease the quantity of a fruit resulting in negqtive quantity
	 * 
	 * @throws BasketException
	 */
	@Test(expected = BasketException.class)
	public void testDecreaseQuantityWithInValidMakingItNegative() throws BasketException {
		basketService.addFruit(new Fruit(10, FruitType.APPLE));
		basketService.decreaseQuantity(new Fruit(20, FruitType.APPLE));
	}

	@Test
	public void testViewBasket() throws BasketException {
		basketService.addFruit(new Fruit(4, FruitType.APPLE));
		basketService.addFruit(new Fruit(10, FruitType.LEMON));
		basketService.viewBasket(basket);
	}

}
