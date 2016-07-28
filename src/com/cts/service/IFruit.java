/**
 * 
 */
package com.cts.service;

import java.math.BigDecimal;

/**
 * @author brijesh
 *
 */
public interface IFruit {
	
	// return total price of fruit (pricePerItem * quantity)
		public BigDecimal getTotalPrice();

		// return name of fruit
		public String getName();
		
		// return no. of quantity of fruit
		public Integer getQuantity() ;
		
		// return cost of a single quantity of fruit
		public BigDecimal getCostPerItem();

}
