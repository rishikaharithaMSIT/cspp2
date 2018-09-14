import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Class for solution.
 */
class Solution {
    /**
     * { var_description }.
     */
    static ArrayList<Item> items = new ArrayList<Item>();
    /**
     * { var_description }.
     */
    static ArrayList<Item> cart = new ArrayList<Item>();
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
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
                //System.out.println(tokens[0] + tokens[1]);
                outerloop:
                for (int i = 0; i < items.size(); i++) {

                    if (items.get(i).productName.equals(tokens[0]) &&
                            Integer.parseInt(items.get(i).quantity) >=
                            Integer.parseInt(tokens[1])) {
                        for (int j = 0; j < cart.size(); j++) {
                            if (items.get(i).productName.equals(
                                        cart.get(j).productName)) {
                                items.get(i).inCartQuantity =
                                    Integer.parseInt(items.get(i).inCartQuantity) +
                                    Integer.parseInt(tokens[1]) + "";
                                break outerloop;
                            }
                        }
                        items.get(i).inCartQuantity = tokens[1];
                        sc.addToCart(items.get(i));
                        cart.add(items.get(i));
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