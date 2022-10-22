public class Task { // Task class

  private String taskId;  // Declare variables
  private String name; // Declare variables
  private String description; // Declare variables

  Task() {  // Constructor
    taskId = "Start"; // Set task id
    name = "Start"; // Set name
    description = "Start description"; // Set description
  }

  Task(String taskId) {  // Constructor
    checkTaskId(taskId); // Check task id
    name = "Start"; // Set name
    description = "Start description";  // Set description
  }

  Task(String taskId, String name) {  // Constructor
    checkTaskId(taskId); // Check task id
    setName(name); // Set name
    description = "Start description"; // Set description
  }

  Task(String taskId, String name, String desc) {  // Constructor
    checkTaskId(taskId);  // Check task id
    setName(name); // Set name
    setdescription(desc);   // Set description
  }

  public final String getTaskId() { // Get task id
    return taskId; // Return task id
  }

  public final String getName() { // Get name
    return name; // Return name
  }

  protected void setName(String name) { // Set name
    if (name == null || name.length() > 20) { // Check if name is null or longer than 20 characters
      throw new IllegalArgumentException( // Throw exception
        "Invalid task description." // Message
      ); 
    } else { // Else
      this.name = name; // Set name
    }
  }

  public final String getdescription() { // Get description
    return description; // Return description
  }

  protected void setdescription(String taskdescription) { // Set description
    if (taskdescription == null || taskdescription.length() > 50) { // Check if description is null or longer than 50 characters
      throw new IllegalArgumentException( // Throw exception
        "Invalid task description." // Message
      );
    } else { // Else
      this.description = taskdescription; // Set description
    }
  }

  private void checkTaskId(String taskId) { // Check task id
    if (taskId == null || taskId.length() > 10) { // Check if task id is null or longer than 10 characters
      throw new IllegalArgumentException( // Throw exception
        "Error. Task ID must be between 1 and 10 characters." // Message
      );
    } else { // Else
      this.taskId = taskId; // Set task id
    }
  }
}
