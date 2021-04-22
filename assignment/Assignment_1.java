package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import effectiveCost.*;

/**
* Class name: Assignment_1
*
* Version info jre1.8.0_221
*
* Copyright notice
* 
* Author info nakulmitra
*
* Creation date  11 January 2021
*
* Last updated By nakulmitra
*
* Last updated Date 14 January 2021
*
* Description This class is make to take the input related to product from user
* and than store it into the list and when end user don;t want to enter more details 
* show him/her the name, price, sale tax, final price of product.
*/

public class Assignment_1 {

	public static void main(String[] args)throws IOException {
		try {
			
			/**
			 * name store the name of product
			 * type store raw,manufactured or imported type of product
			 * quantity store no of items bought by user
			 * price price of product
			 * choice is used to store the desire of user to enter more details
			 */
			String name, type;
			int quantity, n;
			float price;
			String choice = "Y";
			
			InputStreamReader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			
			List<Product> productList = new ArrayList<Product>();
			
			while(choice.equals("Y")) {
				
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
					try {
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
							Product p = new Product();
							p.setName(name);
							p.setPrice(price);
							p.setQuantity(quantity);
							p.setType(type);
							p.setItemCost();
							p.setSaleTax();
							p.setFinalPrice();
							
							productList.add(p);
						
							break;
						}

						else {
							throw new Exception ("Wrong Choice! Please select 1,2 or 3.");
						}

					}
					
					catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
				
				while(true) {
					try {
						System.out.print("\nDo you want to enter details of any other item (YES/NO):");
						choice = br.readLine();
						choice = choice.toUpperCase();
						
						if(choice.equals("N") || choice.equals("NO")) {
							
							System.out.println("\nDescription of Item");
							
							for(Product i : productList) {
								i.showProductDescription();
							}
							
							System.out.println("Thank You!");
							
							br.close();
							r.close();
							break;
						}
						else if(choice.equals("Y") || choice.equals("YES")) {
							choice = "Y";
							break;
						}
						else {
							throw new Exception ("Wrong Choise!");
						}
					}
					catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
