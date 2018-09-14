import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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