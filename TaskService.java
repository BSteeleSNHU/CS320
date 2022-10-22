import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService { // Task service class

  private final List<Task> taskList = new ArrayList<>();  // Create new task list

  private String newUniqueId() { // Method to create new unique id
    return UUID // Return UUID
      .randomUUID() // Random UUID
      .toString() // To string
      .substring(0, Math.min(toString().length(), 10)); // Substring
  }

  private Task searchForTask(String id) throws Exception { // Method to search for task
    int index = 0; // Set index to 0
    while (index < taskList.size()) { // While index is less than task list size
      if (id.equals(taskList.get(index).getTaskId())) { // If id is equal to task id
        return taskList.get(index); 
      }
      index++;  // Increment index
    }
    throw new Exception("The Task does not exist!");  // Throw exception
  }

  public void newTask() { // Method to create new task
    Task task = new Task(newUniqueId());  // Create new task
    taskList.add(task); // Add task to task list
  }

  public void newTask(String name) {  // Method to create new task with name
    Task task = new Task(newUniqueId(), name);  // Create new task with name
    taskList.add(task); // Add task to task list
  }

  public void newTask(String name, String description) {  // Method to create new task with name and description
    Task task = new Task(newUniqueId(), name, description); // Create new task with name and description
    taskList.add(task); // Add task to task list
  }

  public void deleteTask(String id) throws Exception {  // Method to delete task
    taskList.remove(searchForTask(id)); // Remove task from task list
  }

  public void updateName(String id, String name) throws Exception { // Method to update name
    searchForTask(id).setName(name);  // Set name
  }

  public void updateDescription(String id, String description)  throws Exception { // Method to update description
    searchForTask(id).setdescription(description);  // Set description
  }

  public List<Task> getTaskList() { // Method to get task list
    return taskList;  // Return task list
  }
}
