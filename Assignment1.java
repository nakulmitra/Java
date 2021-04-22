import java.io.*;

/**
* Class name: Assignment1
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


public class Assignment1 {

	public static void main(String[] args)throws IOException {
		
		String name;
		float price;
		int quantity;
		String type;
		int n;
		char choice = 'y';
		
		EffectiveCost ec = new EffectiveCost();
		
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		while(choice != 'n') {
			
			System.out.print("Enter Name: ");
			name = br.readLine();
			
			while(true){
			    try{
			        System.out.print("Enter Price: ");
			        price = Float.parseFloat(br.readLine());
			        
			        if(price<=0){
			            throw new Exception("Price can't be less than equal to 0");
			        }
			        else{
			            break;
			        }
			    }
			    catch (Exception ex) {
			        System.out.println("Error:Wrong Input Given "+ex.getMessage());
			    }
			}
			while(true){
			    try{
			        System.out.print("Enter Quantity: ");
			        quantity = Integer.parseInt(br.readLine());
			        
			        if(quantity<=0){
			            throw new Exception("Quantity can't be less than equal to 0");
			        }
			        else{
			            break;
			        }
			    }
			    catch (Exception ex) {
			        System.out.println("Error:Wrong Input Given "+ex.getMessage());
			    }
			}
		
			while(true) {
				System.out.println("1.Raw 2.Manufactured 3.Imported");
				System.out.print("Enter your choise: ");
				n = Integer.parseInt(br.readLine());
				if(n == 1 || n == 2 || n == 3) {
					if(n == 1) {
						type = "Raw";
					}
					
					else if(n == 2) {
						type = "Manufactured";
					}
					
					else {
						type = "Imported";
					}
					
					ec.findCost(name, price, quantity, type);
					break;
				}

				else {
					System.out.println("Wrong Choise");
				}
			}
			
			System.out.print("Do you want to enter details of any other item (y/n):");
			choice = br.readLine().charAt(0);
			if(choice == 'n') {
				System.out.println("Thank You!");
				br.close();
				r.close();
			}
		}

	}
}

class EffectiveCost {
		
	float itemCost;
	float finalPrice;
	float saleTax;
	
	void EfectiveCost(){
		itemCost = 0.0F;
		finalPrice = 0.0F;
		saleTax = 0.0F;
	}
	
	public void findCost(String name, float price, int quantity, String type) {
		
		itemCost = (float) price*quantity;
			
		if(type == "Raw") {
			saleTax = itemCost * (float) 0.125;
			finalPrice = itemCost + saleTax;
		}
		else if(type == "Manufactured") {
			saleTax = itemCost * (float) 0.125;
			saleTax = saleTax + 2*(saleTax + itemCost);
			finalPrice = itemCost + saleTax;
		}
		else {
			saleTax = (itemCost * (float)0.1) + (itemCost * (float)0.125);
			if((saleTax + itemCost)<=100) {
				saleTax += 5;
				finalPrice = itemCost + saleTax;
			}
			else if((saleTax + itemCost)>100 && (saleTax + itemCost)<=200) {
				saleTax += 10;
				finalPrice = itemCost + saleTax;
			}
			else {
				saleTax = (saleTax + itemCost) * (float) 0.05;
				finalPrice = saleTax + itemCost;
			}
		}
		this.show(name , price, saleTax, finalPrice);
	}
	
	void show(String name, float price, float saleTax, float finalPrice) {
		
		System.out.println("\nDescription of Item");
		System.out.println("Name:" + name);
		System.out.println("Price:" + price);
		System.out.println("Sale TAX:" + saleTax);
		System.out.println("Final Price:" + finalPrice);
		System.out.println();
	}
}


