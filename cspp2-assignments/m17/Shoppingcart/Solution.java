import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
class Item{
	String productName;
	String quantity;
	String unitPrice;
	Item(String productName, String quantity, String unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
}
class ShoppingCart {
	static ArrayList<Item> catalog = new ArrayList<Item>();
	static ArrayList<Item> cart = new ArrayList<Item>();
	void addToCatalog(Item item) {
		//System.out.println("hi "+ item.productName);
		catalog.add(item);	
	}
	void showCatalog() {
		//System.out.println(catalog.size());
		for(int i=0; i < catalog.size();i++) {
			System.out.println(catalog.get(i).productName + " "+
				catalog.get(i).quantity + " " + catalog.get(i).unitPrice);
		}
	}
	void addToCart(Item item) {
		cart.add(item);
		System.out.println(cart + " in cart");
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		while(stdin.hasNext()) {
			ShoppingCart sc = new ShoppingCart();
			String line = stdin.nextLine();
			String[] keys = line.split(" ");
			ArrayList<Item> items = new ArrayList<Item>();
			switch(keys[0]) {
				case "Item":
					String[] tokens = keys[1].split(",");
					Item item = new Item(tokens[0], tokens[1], tokens[2]);
					sc.addToCatalog(item);
					items.add(item);
					break;
				case "add":
					tokens = keys[1].split(",");
					System.out.println(items.size());
					for(int i=0;i<items.size();i++) {
						System.out.println(items.get(i).productName +" "+ tokens[0]);
						if(items.get(i).productName == tokens[0] &&
							items.get(i).quantity == tokens[1]&&
							items.get(i).unitPrice == tokens[2]){
							System.out.println("here");
							sc.addToCart(items.get(i));
						}
					}
					//addToCart(item);
					break;
				case "show":
					//sc.showCatalog();
			}
		}
	}
}