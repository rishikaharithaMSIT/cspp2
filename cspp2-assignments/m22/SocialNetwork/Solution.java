import java.util.*;
import java.io.*;

class Solution {
	static TreeMap<String, ArrayList<String>> socialNetwork = new TreeMap<>();
	public static void main(String[] args) {
		
		try {
			File file = new File("Testcases_SocialNetwork\\input001.txt");
			Scanner scan  =  new Scanner(file);

			while(scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(" ");
				switch(tokens[0]) {
					case "Create":
						int num = Integer.parseInt(tokens[1]);
						//System.out.println(num);
						while(num > 0) {
							String lines = scan.nextLine();
							//System.out.println(lines);
							lines = lines.substring(0,lines.length()-1);
							String[] tokenss = lines.split(" is connected to ");
							String[] people = tokenss[1].split(", ");
							ArrayList<String> network = new ArrayList<>(Arrays.asList(people));
							socialNetwork.put(tokenss[0], network);
							//System.out.println(socialNetwork);
							num--;				
						}
						//createNetwork(tokens[11]);
						break;
					case "getConnections":
						if(socialNetwork.containsKey(tokens[1])) {
							ArrayList<String> connections = socialNetwork.get(tokens[1]);
							System.out.println(connections);
						} else {
							System.out.println("Not a user in Network");
						}
						break;
					case "addConnections":
						//String[] values = tokens[1].split(",");
						if(socialNetwork.containsKey(tokens[1]) && socialNetwork.containsKey(tokens[2])) {
							socialNetwork.get(tokens[1]).add(tokens[2]);
						} else {
							System.out.println("Not a user in Network");
						}
						//System.out.println(socialNetwork);
						break;
					case "CommonConnections":
						if(socialNetwork.containsKey(tokens[1]) && socialNetwork.containsKey(tokens[2])) {
							 ArrayList<String> list1 = socialNetwork.get(tokens[1]);
							 ArrayList<String> list2 = socialNetwork.get(tokens[2]);
							 ArrayList<String> common = new ArrayList<>(list1);
							 // for(int i = 0; i < list1.size();i++) {
							 // 	if(list2.contains(list1.get(i))) {
							 // 		common.add(list1.get(i));
							 // 	}
							 // }
							 common.retainAll(list2);
							 System.out.println(common);
						}
						break;
					case "Network":
						//System.out.println(socialNetwork);
						String[] keyss = socialNetwork.keySet().toArray(new String[socialNetwork.keySet().size()]);
						//System.out.println(Arrays.toString(keyss));
						for(int i =0;i< keyss.length-1;i++){
							System.out.print(keyss[i] + ": ");
	             			System.out.print(socialNetwork.get(keyss[i]) +", ");
						 }
						System.out.print(keyss[keyss.length-1] + ": ");
						System.out.print(socialNetwork.get(keyss[keyss.length-1]));
						// for (String k: socialNetwork.keySet()) { 
	     //        			System.out.print(k + ": ");
	     //        			System.out.print(socialNetwork.get(k) +", "+);
	     //    			}
	        			System.out.println();
						break;

					}
								
			}
		} catch (IOException io) {
			System.out.println("File not found");
		}
	}
	public static void createNetwork(String create) {
		try {
			File file = new File("Testcases_SocialNetwork\\input000.txt");
			Scanner scan  =  new Scanner(file);
			int num = Integer.parseInt(create);
			while(num > 0) {
				String line = scan.nextLine();
				String[] tokens = line.split(" is connected to ");
				String[] people = tokens[1].split(", ");
				ArrayList<String> network = new ArrayList<>(Arrays.asList(people));
				socialNetwork.put(tokens[0], network);
				System.out.println(socialNetwork);
				num--;				
			}
		} catch (IOException io) {
			System.out.println("File not found");
		}
	}
}