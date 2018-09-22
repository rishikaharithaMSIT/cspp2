import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
/**
 * Class for todoist.
 */
class Todoist {
    Task[] tasks;
    int size;
    Todoist() {
        tasks = new Task[10];
        size = 0;
    }
    public void addTask(Task task) {
        try {
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
        for (int i = 0; i < size; i++) {
            if (tasks[i].assignedTo.equals(name) && tasks[i].status.equals("todo")) {
                if (tasks[i].important && !tasks[i].urgent) {
                    return tasks[i];
                }
            }
        }
        return null;
    }
    public Task[] getNextTask(String name, int n) {
        Task[] getTasks = new Task[n];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].assignedTo.equals(name) && tasks[i].status.equals("todo")) {
                if (tasks[i].important && !tasks[i].urgent) {
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
        for (int i = 0; i < size; i++) {
            if (tasks[i].status.equals("todo")) totalTime += tasks[i].timeToComplete;
        }
        return totalTime;
    }
    public String toString() {
        String display = "";
        for (int i = 0; i < size; i++) {
            //System.out.println(tasks[i].important + " - " + tasks[i].urgent);
            String imp = "Not Important";
            String urg = "Not Urgent";
            if (tasks[i].important) imp = "Important";
            if (tasks[i].urgent) urg = "Urgent";
            display += tasks[i].title + ", " + tasks[i].assignedTo + ", " + tasks[i].timeToComplete + ", " + imp + ", " + urg + ", " + tasks[i].status + "\n";

        }
        return display;
    }
}