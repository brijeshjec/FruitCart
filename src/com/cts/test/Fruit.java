/**
 * 
 */
package com.cts.test;

import java.math.BigDecimal;

import com.cts.service.IFruit;

/**stub implementation of IFruit to test out
 * @author brijesh
 *
 */
public enum Fruit implements IFruit{
	
	// pricing and quantity are given statically
	
	
	APPLE(new BigDecimal(120.5),2), ORANGE(new BigDecimal(12.50),3), PEACHES(new BigDecimal(10.00),1), BANANA(
			new BigDecimal(5.50),2), LEMON(new BigDecimal(1.50),4);

	private BigDecimal itemTotalPrice;
	private BigDecimal costPerItem;
	private Integer quantity;

	
	
	/**
	 * @param price
	 * @param quantity
	 */
	Fruit(BigDecimal price,Integer quantity) {
		
		this.costPerItem = price;
		this.quantity=quantity;
		this.itemTotalPrice=price.multiply(new BigDecimal(quantity));
	}

	

	/* (non-Javadoc)
	 * @see com.cts.client.service.IFruit#getName()
	 */
	@Override
	public String getName() {
		
		return this.name();
	}

	
	
	/* (non-Javadoc)
	 * @see com.cts.client.service.IFruit#getCostPerItem()
	 */
	@Override
	public BigDecimal getCostPerItem() {
		return costPerItem;
	}


	
	/* (non-Javadoc)
	 * @see com.cts.client.service.IFruit#getQuantity()
	 */
	@Override
	public Integer getQuantity() {
		return quantity;
	}

	/* (non-Javadoc)
	 * @see com.cts.client.service.IFruit#getTotalPrice()
	 */
	@Override
	public BigDecimal getTotalPrice() {
		return this.itemTotalPrice;
	}

}
