import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

class Todoist {
	Task[] tasks;
	int size;
	Todoist() {
		tasks = new Task[10];
		size = 0;
	}
	public void addTask(Task task) {
		try{
			tasks[size] = task;
			size++;
		} catch (Exception e) {
			resize();
			addTask(task);
		}
		
	}
	void resize() {
        tasks = Arrays.copyOf(tasks, 2 * size);
    }
    public Task getNextTask(String name) {
    	for(int i =0; i< size; i++) {
    		if(tasks[i].assignedTo.equals(name) && tasks[i].status.equals("todo")) {
    			if(tasks[i].important && !tasks[i].urgent) {
    				return tasks[i];
    			}
    		}
    	}
    	return null;
    }
    public Task[] getNextTask(String name, int n) {
    	Task[] getTasks = new Task[n];
    	int index = 0;
    	for(int i =0; i< size; i++) {
    		if(tasks[i].assignedTo.equals(name) && tasks[i].status.equals("todo")) {
    			if(tasks[i].important && !tasks[i].urgent) {
    				getTasks[index] = tasks[i];
    				index++;
    				if (index == n) break;
    			}
    		}
    	}
    	return getTasks;
    }
    public int totalTime4Completion() {
    	int totalTime = 0;
    	for(int i =0; i < size;i++) {
    		if (tasks[i].status.equals("todo")) totalTime += tasks[i].timeToComplete;
    	}
    	return totalTime;
    }
    public String toString(){
    	
		String display = "";
    	for (int i =0; i< size;i++) {
    	//System.out.println(tasks[i].important + " - " + tasks[i].urgent);
    	String imp = "Not Important";
		String urg = "Not Urgent";
		if(tasks[i].important) imp = "Important";
		if(tasks[i].urgent) urg = "Urgent";
		display += tasks[i].title + ", " + tasks[i].assignedTo+", "+ tasks[i].timeToComplete+", "+ imp+", "+ urg+", "+ tasks[i].status + "\n";
		
    	}
    	return display;
    }

}
class Task {
	String title;
	String assignedTo;
	int timeToComplete;
	boolean important;
	boolean urgent;
	String status;

	Task(String title, String assignedTo, int timeToComplete, boolean important,
	     boolean urgent, String status) throws Exception {
		if (title.equals("") || title == null) throw new Exception("Title not provided");
		if (timeToComplete < 0) throw new Exception("Invalid timeToComplete " + timeToComplete);
		if (!status.equals("todo") && !status.equals("done")) throw new Exception("Invalid status " + status);
		this.title = title;
		this.assignedTo = assignedTo;
		this.timeToComplete = timeToComplete;
		this.important = important;
		this.urgent = urgent;
		this.status = status;
	}
	public String toString() {
		String imp = "Not Important";
		String urg = "Not Urgent";
		if(important) imp = "Important";
		if(urgent) urg = "Urgent";
		String display = title + ", " + assignedTo+", "+ timeToComplete+", "+ imp+", "+ urg+", "+ status;
		return display;
	}
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			case "print-todoist":
				System.out.println(todo);
				break;
			case "get-next":
				System.out.println(todo.getNextTask(tokens[1]));
				break;
			case "get-next-n":
				int n = Integer.parseInt(tokens[2]);
				Task[] tasks = todo.getNextTask(tokens[1], n);
				System.out.println(Arrays.deepToString(tasks));
				break;
			case "total-time":
				System.out.println(todo.totalTime4Completion());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			System.out.println(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
