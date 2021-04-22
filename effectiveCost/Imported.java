package effectiveCost;

/**
* Class name: Imported
*
* Version info jre1.8.0_221
*
* Copyright notice
* 
* Author info nakulmitra
*
* Creation date  11 Jan 2021
*
* Last updated By nakulmitra
*
* Last updated Date 14 Jan 2021
*
* Description
*/

public class Imported {
	
	private float itemCost;
	private float saleTax;
	private float finalPrice;
	
	
	public void Imported() {
		itemCost = 0.0F;
		saleTax = 0.0F;
		finalPrice = 0.0F;
	}

	
	EffectiveCost ec = new EffectiveCost();
	
	/**
	 * 
	 * @param price
	 * @param quantity
	 */
	public void setItemCost(float price, int quantity) {
		itemCost = ec.calculateItemCost(price, quantity);
	}
	
	/**
	 * Set saleTax
	 */
	public void setSaleTax() {
		saleTax = ec.calculateSaleTax(itemCost, "Imported");
	}
	
	/**
	 * Set finalPrice
	 */
	public void setFinalPrice() {
		finalPrice = ec.calculateFinalPrice(saleTax, itemCost);
	}
	
	/**
	 * 
	 * @return itemCost
	 */
	public float getItemCost() {
		return itemCost;
	}
	
	/**
	 * 
	 * @return saleTax
	 */
	public float getSaleTax() {
		return saleTax;
	}
	
	/**
	 * 
	 * @return finalPrice
	 */
	public float getFinalPrice() {
		return finalPrice;
	}
	
	/**
	 * 
	 * @param name
	 * @param price
	 */
	public void showDescription(String name, float price) {
		ec.showDescription(name, price, saleTax, finalPrice);
	}
}
