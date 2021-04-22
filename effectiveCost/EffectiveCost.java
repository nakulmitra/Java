package effectiveCost;

/**
* Class name: EffectiveCost
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

public class EffectiveCost {
	
	/**
	 * 
	 * @param price
	 * @param quantity
	 * @return itemCost
	 */
	public float calculateItemCost(float price, int quantity) {
		float itemCost = (float) price * quantity;
		return (itemCost);
	}
	
	/**
	 * 
	 * @param itemCost
	 * @param type
	 * @return saleTax
	 */
	public float calculateSaleTax(float itemCost, String type) {
		float saleTax;
		
		if(type.equals("Raw")) {
			saleTax = itemCost * (float) 0.125;
		}
		
		else if(type.equals("Manufactured")) {
			saleTax = itemCost * (float) 0.125;
			saleTax = saleTax + 2 * (saleTax + itemCost);
		}
		
		else {
			saleTax = (itemCost * (float) 0.1) + (itemCost * (float) 0.125);
			
			if((saleTax + itemCost)<=100) {
				saleTax += 5;
			}
			else if((saleTax + itemCost)>100 && (saleTax + itemCost)<=200) {
				saleTax += 10;
			}
			else {
				saleTax = (saleTax + itemCost) * (float) 0.05;
			}
		}
		
		return (saleTax);
	}
	
	/**
	 * 
	 * @param saleTax
	 * @param itemCost
	 * @return FinalPrice
	 */
	public float calculateFinalPrice(float saleTax, float itemCost) {
		float finalPrice = itemCost + saleTax;
		return (finalPrice);
	}
	
	/**
	 * 
	 * @param name
	 * @param price
	 * @param saleTax
	 * @param finalPrice
	 */
	public void showDescription(String name, float price, float saleTax, float finalPrice) {
		System.out.println("\nDescription of Item");
		System.out.println("Name:" + name);
		System.out.println("Price:" + price);
		System.out.println("Sale TAX:" + saleTax);
		System.out.println("Final Price:" + finalPrice);
		System.out.println();
	}
}
