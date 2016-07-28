package com.cts.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * This method iterates through the fruit list and computes sum of all the
	 * individual prices in fruit entry-set.
	 * 
 * @author brijesh
 *
 */
public class BasketPriceCalculator {
	
	
	public final  BigDecimal calculateBasketPrice(List<? extends IFruit> fruitsBasket) {
		inputValidation(fruitsBasket);
		
	Iterator<? extends IFruit>   itr=	fruitsBasket.iterator();
	BigDecimal totalBasketPrice=new BigDecimal(0);
	while(itr.hasNext())
	{
		IFruit ifruit=	itr.next();
		totalBasketPrice=totalBasketPrice.add(ifruit.getTotalPrice());
	}
		
		
		return totalBasketPrice;
	}

	/**
	 * Validate input list 
	 * 
	 * @param fruitsBasket
	 */
	private final static void inputValidation(List<? extends IFruit> fruitsBasket) {
		if (fruitsBasket == null) {
			throw new IllegalArgumentException("Please provide a non-empty Fruit Basket");
		}
		for (IFruit f : fruitsBasket) {
			if (f == null || f.getTotalPrice() == null) {
				throw new IllegalArgumentException("Please provide only non-null fruit items in basket");
			}
		}
	}


}
