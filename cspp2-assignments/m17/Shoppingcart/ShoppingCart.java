import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ShoppingCart {
	static ArrayList<Item> catalog = new ArrayList<Item>();
	
	static ArrayList<Item> cart = new ArrayList<Item>();
	static int apply = 0;
	static boolean isFirst = false;
	void addToCatalog(Item item) {
		//System.out.println("hi "+ item.productName);
		
			catalog.add(item);
			
	}
	void showCatalog() {
		//System.out.println(catalog.size());
		for (int i = 0; i < catalog.size(); i++) {
			System.out.println(catalog.get(i).productName + " " +
			                   catalog.get(i).quantity + " " + catalog.get(i).unitPrice);
		}
	}
	void showCart() {
		//System.out.println(catalog.size());
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i).productName + " " +
			                   cart.get(i).inCartQuantity);
		}
	}
	void addToCart(Item item) {
		cart.add(item);
		
		// if (isFirst == false) {
		// 	cart.add(item);
		// 	isFirst = true;
		// } else{	
		// // 	int inCart = -1;
		//  	for (int i = 0; i < cart.size(); i++) {
		// // 		System.out.println(cart.get(i).inCartQuantity + " - " + cart.get(i).productName);
		//  		if(cart.get(i).productName.equals(item.productName)){
		//  			//System.out.println(cart.get(i).inCartQuantity + " " + item.inCartQuantity +" 99999999999999");
		//  			cart.get(i).inCartQuantity = item.inCartQuantity;
		// // 			inCart = i;
		//  			break;
		//  		} else {
		//  			cart.add(item);
		//  			break;
		//  		}
		//  	}
		// // 	if(inCart == -1) {
		// // 		cart.add(item);
		// // 	}else {
		// // 		cart.get(inCart).inCartQuantity = Integer.parseInt(cart.get(inCart).inCartQuantity) + Integer.parseInt(item.inCartQuantity) + "";
		//  	}
		//  }

	}
	void removeFromCart(Item item, int quan) {
		int cartQuan = Integer.parseInt(item.inCartQuantity);
		if (quan < cartQuan) {
			//System.out.println(item.productName + " in remove");
			item.inCartQuantity = (cartQuan - quan) + "";
		} else {
			cart.remove(item);
		}

	}
	float getTotalAmount() {
		float totalAmount = 0.0f;
		for (int i = 0; i < cart.size(); i++) {
			int quantity = Integer.parseInt(cart.get(i).inCartQuantity);
			float unitPrice = cart.get(i).unitPrice;
			totalAmount += (quantity * unitPrice);
		}
		return totalAmount;

	}
	float getPayableAmount() {
		float total = 0.0f;
		float tax = 0.0f;
		
		//System.out.println("discountttttttttttttttt" + discount);
		for (int i = 0; i < cart.size(); i++) {
			int quantity = Integer.parseInt(cart.get(i).inCartQuantity);
			float unitPrice = cart.get(i).unitPrice;
			total += (quantity * unitPrice);
		}
		//System.out.println("Total"+totalAmount);
		float discount = (apply / 100.0f) * total;
		tax = Math.round((0.15f * (total - discount))*100.0)/100.0f;
		//System.out.println("taxxxxxxxxxxxxxx" + tax);
		float totalAmount = total + tax - discount;
		//System.out.println("total ammmonttttttttttt"+totalAmount);
		return Math.round(totalAmount*100.0)/100.0f;
	}
	void printInvoice() {

		float total = getTotalAmount();
		float discount = (apply / 100.0f) * total;
		float tax = Math.round((0.15f * (total - discount))*100.0)/100.0f;
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i).productName + " " + cart.get(i).inCartQuantity + " " + cart.get(i).unitPrice);
		}
		//System.out.println("totalAmount: "+total);
		System.out.println("Total:" + total);
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}
	boolean applyCoupon(String coupon) {
		String[] coupons = coupon.split("D");
		//System.out.println("couponnnnnnnnnnnnnnnnnnnnnnnn" + coupons[1]);
		int cou =  Integer.parseInt(coupons[1]);
		if (cou == 10 || cou == 20 || cou == 30 || cou == 50) {
			apply = cou;
			return true;
		}
		return false;
	}
}