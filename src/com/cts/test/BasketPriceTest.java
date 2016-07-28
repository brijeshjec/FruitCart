package com.cts.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.cts.service.BasketPriceCalculator;
import com.cts.service.IFruit;

/**
 * Test class for {@link BasketPriceCalculator}
 * @author brijesh
 *
 */
public class BasketPriceTest {
	
	private List<IFruit> fruitsBasket = new ArrayList<>();;
	private BigDecimal expectedValue = BigDecimal.ZERO;

	
	@Before
	public void setUp() {
		fruitsBasket.clear();
		expectedValue = BigDecimal.ZERO;
		fruitsBasket.add(Fruit.BANANA);
		fruitsBasket.add(Fruit.APPLE);
		fruitsBasket.add(Fruit.LEMON);
		fruitsBasket.add(Fruit.PEACHES);
		fruitsBasket.add(Fruit.ORANGE);
		
		
		
		for (Fruit f : Fruit.values()) {
			expectedValue = expectedValue.add(f.getTotalPrice());
		}
	}
	
	
	/**
	 * Send a null list to test {@link BasketPricer#validateInput(List)}
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void whenIllegalArgumentThenExceptionIsThrown() {
		BasketPriceCalculator calculator = Mockito.mock(BasketPriceCalculator.class);
		
		calculator.calculateBasketPrice(null);

	}
	
	
	/**
	 * Send a null Fruit item in input list
	 * {@link BasketPricer#calculateBasketPrice(List)}
	 */
	/**
	 * 
	 */
	@Test(expected = RuntimeException.class)
	public final void whenRuntimeExceptionIsThrown() {
		BasketPriceCalculator calculator = Mockito.mock(BasketPriceCalculator.class);
		
		fruitsBasket.add(null);
		System.out.println(calculator.calculateBasketPrice(fruitsBasket));
	}
	
	/**
	 * make sure we are summing up fruit prices correctly in basket Test case to
	 * cover {@link BasketPricer#calculateBasketPrice(List)}
	 * 
	 */
	@Test
	public final void assertBasketIsPricedCorrectly() {
		
		BasketPriceCalculator calculator = Mockito.mock(BasketPriceCalculator.class);
		BigDecimal result = calculator.calculateBasketPrice(fruitsBasket);
		Assert.assertEquals(expectedValue, result);
	}
	
	
}
