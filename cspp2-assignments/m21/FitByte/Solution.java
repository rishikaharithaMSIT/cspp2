import java.util.*;
import java.io.*;
class Food {
	private String item;
	private String quantity;
	private String time;
	Food(String item, String quantity, String time) {
		this.item = item;
		this.quantity = quantity;
		this.time = time;
	}
	public String getItem() {
		return item;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getTime() {
		return time;
	}

}

class Water {
	private String quantity;
	private String time;
	Water(String quantity, String time) {
		this.quantity = quantity;
		this.time = time;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getTime() {
		return time;
	}
}
class Activity {
	private String name;
	private String start;
	private String end;
	private String notes;
	Activity(String name, String start, String end, String notes) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.notes = notes;
	}
	public String getName() {
		return name;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}
	public String getNotes() {
		return notes;
	}
}

class Weight {
	private String weight;
	private String fat;
	private String time;
	Weight(String weight, String time, String fat) {
		this.weight = weight;
		this.fat = fat;
		this.time = time;
	}
	public String getWeight() {
		return weight;
	}
	public String getFat() {
		return fat;
	}
	public String getTime() {
		return time;
	}
}

class Sleep {
	private String start;
	private String end;
	Sleep(String start, String end) {
		this.start = start;
		this.end = end;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}
}

class DayLog {
	private ArrayList<Food> foodList = new ArrayList<Food>();
	private ArrayList<Water> waterList = new ArrayList<Water>();
	private ArrayList<Activity> activityList = new ArrayList<Activity>();
	private ArrayList<Weight> weightList = new ArrayList<Weight>();
	private ArrayList<Sleep> sleepList = new ArrayList<Sleep>();

	private String date;
	DayLog(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void addFood(String food) {
		String[] foods = food.split(",");
		Food foodObj = new Food(foods[0], foods[1], foods[2]);
		foodList.add(foodObj);
		//System.out.println(foodList + " - "+ date);
	}
	public void addWater(String water) {
		String[] wat = water.split(",");
		Water waterObj = new Water(wat[0], wat[1]);
		waterList.add(waterObj);
		//System.out.println(waterList + " - "+ date);
	}
	public void addActivity(String activity) {
		String[] act = activity.split(",");
		Activity activityObj = new Activity(act[0], act[1], act[2], act[3]);
		activityList.add(activityObj);
		//System.out.println(waterList + " - "+ date);
	}
	public void addWeight(String weight) {
		String[] wei = weight.split(",");
		Weight weightObj = new Weight(wei[0], wei[1],wei[2]);
		weightList.add(weightObj);
		//System.out.println(waterList + " - "+ date);
	}
	public void addSleep(String sleep) {
		String[] slep = sleep.split(",");
		Sleep sleepObj = new Sleep(slep[0], slep[1]);
		sleepList.add(sleepObj);
		//System.out.println(waterList + " - "+ date);
	}
	public void foodLog() {
		System.out.println("Food");
		if (foodList.size() == 0) System.out.println("None");
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Time:" + foodList.get(i).getTime());
			System.out.println("Name:" + foodList.get(i).getItem());
			System.out.println("Quantity:" + foodList.get(i).getQuantity());
		}
	}
	public void waterLog() {
		System.out.println("Water");
		if (waterList.size() == 0) System.out.println("None");
		for (int i = 0; i < waterList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Quantity:" + waterList.get(i).getQuantity());
		}
	}
	public void activityLog() {
		System.out.println("PhysicalActivity");
		if (activityList.size() == 0) System.out.println("None");
		for (int i = 0; i < activityList.size(); i++) {
			System.out.println("Name" + activityList.get(i).getName());
			System.out.println("Notes" + activityList.get(i).getNotes());
			System.out.println("Date:" + date);
			System.out.println("Starttime: " + activityList.get(i).getStart());
			System.out.println("Endtime: " + activityList.get(i).getEnd());
		}
	}
	public void weightLog() {
		System.out.println("Weight");
		if (weightList.size() == 0) System.out.println("None");
		for (int i = 0; i < weightList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Time:" + weightList.get(i).getTime());
			System.out.println("Weight:" + weightList.get(i).getWeight());
			System.out.println("Fat:" + weightList.get(i).getFat());
		}
	}
	public void sleepLog() {
		System.out.println("Sleep");
		if (sleepList.size() == 0) System.out.println("None");
		for (int i = 0; i < sleepList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Starttime:" + sleepList.get(i).getStart());
			System.out.println("Endtime:" + sleepList.get(i).getEnd());
		}
	}
	public void printLog() {
		foodLog();
		waterLog();
		activityLog();
		weightLog();
		sleepLog();
	}
}

public class Solution {
	static ArrayList<DayLog> daylogs = new ArrayList<DayLog>();
	//static DayLog currentday = null;
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] keys = line.split(" ");
				String seeCase = null;
				int flagg = 0;

				String date = keys[1];
				DayLog currentday = null;
				int flag = 0;
				for (int i = 0; i < daylogs.size(); i++) {
					if (date.equals(daylogs.get(i).getDate())) {
						currentday = daylogs.get(i);
						flag = 1;
					}
				}
				if (daylogs.size() == 0 || flag == 0) {
					DayLog daylog = new DayLog(date);
					daylogs.add(daylog);
					currentday = daylog;
				}

				switch (keys[0]) {
				case "food":
					currentday.addFood(keys[2]);
					break;
				case "water":
					currentday.addWater(keys[2]);
					break;
				case "activity":
					currentday.addActivity(keys[2]);
					break;
				case "weight":
					currentday.addWeight(keys[2]);
					break;
				case "sleep":
					currentday.addSleep(keys[2]);
					break;
				case "foodLog":
					currentday.foodLog();
					System.out.println();
					break;
				case "waterLog":
					currentday.waterLog();
					System.out.println();
					break;
				case "activityLog":
					currentday.activityLog();
					System.out.println();
					break;
				case "sleepLog":
					currentday.sleepLog();
					System.out.println();
					break;
				case "weightLog":
					currentday.weightLog();
					System.out.println();
					break;
				case "print":
					currentday.printLog();
					break;

				}

			}
		} catch (IOException io) {
			System.out.println("File not found");
		}
	}
}