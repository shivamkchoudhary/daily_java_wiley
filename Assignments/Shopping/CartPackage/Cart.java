package CartPackage;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import AdminPackage.Product;
import CartPackage.Cart;
import BillPackage.Payments;

public class Cart {

	static List<Product> mycart = new ArrayList<Product>();

	public static List<Product> addToCart(Product p) {

		mycart.add(p);
		return mycart;
	}

}