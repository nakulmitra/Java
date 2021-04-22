package effectiveCost;

/**
* Class name: Product
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
* Description Product class is use to store the information related to
* some product and when needed can be access very easily.
*/

public class Product {
	
	/**
	 * Product variables to store the details of a product
	 */
	private String name, type;
	private float price, itemCost, saleTax, finalPrice;
	private int quantity;
	
	/**
	 * set the name of product
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * set the type of product
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * set the price of product
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * set the quantity of product
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * set the itemCost of product
	 */
	public void setItemCost() {
		this.itemCost = this.price * this.quantity;
	}
	
	/**
	 * set the saleTax of product
	 */
	public void setSaleTax() {
		CostEstimation ce = new CostEstimation();
		this.saleTax = ce.calculateSaleTax(this.itemCost, this.type);
	}
	
	/**
	 * set the finalPrice of product
	 */
	public void setFinalPrice() {
		this.finalPrice = this.itemCost + this.saleTax;
	}
	
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return price
	 */
	public float getPrice() {
		return this.price;
	}
	
	/**
	 * 
	 * @return saleTax
	 */
	public float getSaleTax() {
		return this.saleTax;
	}
	
	/**
	 * 
	 * @return fianlPrice
	 */
	public float getFinalPrice() {
		return this.finalPrice;
	}
	
	public void showProductDescription() {
		CostEstimation ce = new CostEstimation();
		ce.showDescription(this.name, this.price, this.saleTax, this.finalPrice);
	}
}
