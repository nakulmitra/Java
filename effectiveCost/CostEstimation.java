package effectiveCost;

public class CostEstimation {
	
	/**
	 * calculate the saleTax of a product
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
	 * To show the details of a product
	 * @param name
	 * @param price
	 * @param saleTax
	 * @param finalPrice
	 */
	public void showDescription(String name, float price, float saleTax, float finalPrice) {
		System.out.println("Name:" + name);
		System.out.println("Price:" + price);
		System.out.println("Sale TAX:" + saleTax);
		System.out.println("Final Price:" + finalPrice);
		System.out.println();
	}

}
