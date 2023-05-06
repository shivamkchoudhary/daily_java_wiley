package CustomerPackage;

import java.util.ArrayList;
import java.util.Arrays;

import AdminPackage.AdminService;
import java.util.List;
import java.util.Scanner;
import CartPackage.Cart;
import BillPackage.*;
import AdminPackage.Product;

public class Customer {

//Create a menu
//The main functions are viewing products, searching for products, adding and removing products from the cart,
//view the cart, and proceeding to the payment function.
	Scanner in = new Scanner(System.in);
//Cart c=new Cart();
	List<Product> l = new ArrayList<>();

	public Customer(String s) {
		System.out.println("********Welcome To The Shopping App " + s + "********");
		System.out.println("********************************************");

		for (;;) {
			System.out.println("********************************************");

			System.out.println("1. VIEW PRODUCTS");
			System.out.println("2. SEARCH OF THE PRODUCT");
			System.out.println("3. ADD PRODUCT TO THE CART");
			System.out.println("4. REMOVE PRODUCT FROM CART");
			System.out.println("5. VIEW CART");
			System.out.println("6. PROCEED TO PAYMENT");
			System.out.println("7. EXIT");
			System.out.println("********************************************");
			System.out.println("Enter your choice:");
			int num = in.nextInt();
			in.nextLine();
			AdminService adminService = new AdminService();
			switch (num) {

			case 1:
				adminService.viewProducts();
				break;
			case 2:
				adminService.searchProduct();
				break;
			case 3:
				System.out.println("Enter the name of the product:");
				String name1 = in.nextLine();
				Product p;
				if ((p = adminService.searchProduct(name1)) != null) {
					System.out.println("Product is available");
					l = Cart.addToCart(p);

				} else
					System.out.println("Product Unavailable");
				break;
			case 4:
				
				
				
				if(l.size()==0) {
					System.out.println("Cart is Empty");
				}
				else {
					System.out.println("Enter the name of the product to be removed:");
					String name2 = in.nextLine();
					Product rmp;
					int count = -1;
					for(Product pr:l) {
						count++;
						if(pr.getName().equals(name2)) {
//							l.remove(count);
							System.out.println("Product Removed");
							break;
						}
						else {
							System.out.println("Invalid Data");
						}

					}
					l.remove(count);
					
					
				}
				break;
			case 5:
				
				if(l.size()==0) {
					System.out.println("Cart is empty");
				}
				else {
					System.out.println("Products in the cart");
					for (Product pro : l) {
						
						System.out.println(pro.getName());
					}
				}

				
				break;
			case 6:
				System.out.println("Proceed to Billing");
				Bill b = new Bill(l);
				break;
			case 7:
				System.out.println("****Logging out****");
				System.exit(0);
//
			}
//
//
//
//
		}
	}

}
