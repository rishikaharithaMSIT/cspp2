import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
class Item {
	String productName;
	String quantity;
	float unitPrice;
	String inCartQuantity = "0";
	Item(String productName, String quantity, String unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = Float.parseFloat(unitPrice);
	}
}
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
		//cart.add(item);
		if (isFirst == false) {
			cart.add(item);
			isFirst = true;
		} else{	
			for (int i = 0; i < cart.size(); i++) {

				if((cart.get(i).productName).equals(item.productName)){
					//System.out.println(cart.get(i).productName + " " + item.productName +" 99999999999999");
					cart.get(i).inCartQuantity = (Integer.parseInt(cart.get(i).inCartQuantity)+Integer.parseInt(item.inCartQuantity))+"";
					break;
				}else {
					cart.add(item);
					break;
				}
			}
		}

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
class Solution {
	static ArrayList<Item> items = new ArrayList<Item>();
	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		boolean couponApplied = false;
		while (stdin.hasNext()) {
			ShoppingCart sc = new ShoppingCart();
			String line = stdin.nextLine();
			String[] keys = line.split(" ");

			switch (keys[0]) {
			case "Item":
				String[] tokens = keys[1].split(",");
				Item item = new Item(tokens[0], tokens[1], tokens[2]);
				sc.addToCatalog(item);
				items.add(item);
				break;
			case "add":
				tokens = keys[1].split(",");
				//System.out.println(items.size());
				for (int i = 0; i < items.size(); i++) {
					//System.out.println(items.get(i).productName +" "+ tokens[0]);
					//System.out.println(items.get(i).quantity +" "+ tokens[1]);
					//System.out.println(items.get(i).unitPrice +" "+ tokens[2]);

					if (items.get(i).productName.equals(tokens[0]) &&
					        Integer.parseInt(items.get(i).quantity) >= Integer.parseInt(tokens[1])) {
						items.get(i).inCartQuantity = tokens[1];
						sc.addToCart(items.get(i));
						break;
					}
				}
				//addToCart(item);
				break;
			case "show":
				sc.showCart();
				break;
			case "catalog":
				sc.showCatalog();
				break;
			case "remove":
				tokens = keys[1].split(",");
				for (int i = 0; i < items.size(); i++) {
					if (items.get(i).productName.equals(tokens[0])) {
						//System.out.println(items.get(i).productName + " " +tokens[0]);
						sc.removeFromCart(items.get(i),
						                  Integer.parseInt(tokens[1]));
						break;
					}
				}
				break;
			case "totalAmount":
				System.out.println("totalAmount: " + sc.getTotalAmount());
				break;
			case "payableAmount":
				System.out.println("Payable amount: " + sc.getPayableAmount());
				break;
			case "coupon":

				if (couponApplied == false) {
					if (sc.applyCoupon(keys[1])) {
						couponApplied = true;
					} else {
						System.out.println("Invalid coupon");
					}
				}
				break;
			case "print":
				sc.printInvoice();
				break;

			}
		}
	}
}