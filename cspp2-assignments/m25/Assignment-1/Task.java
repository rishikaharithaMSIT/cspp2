import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for task.
 */
class Task {
	String title;
	String assignedTo;
	int timeToComplete;
	boolean important;
	boolean urgent;
	String status;
	/**
	 * Constructs the object.
	 *
	 * @param      title           The title
	 * @param      assignedTo      The assigned to
	 * @param      timeToComplete  The time to complete
	 * @param      important       The important
	 * @param      urgent          The urgent
	 * @param      status          The status
	 */
	
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