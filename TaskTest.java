import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

  private String id, name, description; // Declare variables
  private String longId, longName, longDescription; // Declare variables

  @BeforeEach // Set variables
  void set() { 
    id = "1234567890"; // Set id
    name = "Name"; // Set name
    description = "Description."; // Set description
    longId = "97052837520934867023958274"; // Set long id
    longName = "The long name is more than the characters for a normal name"; // Set long name
    longDescription ="The long description is more than the characters for a normal description"; // Set long description
  }

  @Test
  void getTaskIdTest() { // Test for get task id
    Task task = new Task(id); // Create new task
    Assertions.assertEquals(id, task.getTaskId()); // Check if task id is equal to the id given
  }

  @Test
  void getNameTest() { // Test for get name
    Task task = new Task(id, name); // Create new task with name
    Assertions.assertEquals(name, task.getName()); // Check if task name is equal to the name given
  }

  @Test
  void getDescriptionTest() { // Test for get description
    Task task = new Task(id, name, description); // Create new task with name and description
    Assertions.assertEquals(description, task.getdescription()); // Check if task description is equal to the description given
  }

  @Test
  void setNameTest() { // Test for set name
    Task task = new Task(); // Create new task
    task.setName(name); // Set name
    Assertions.assertEquals(name, task.getName()); // Check if task name is equal to the name given
  }

  @Test
  void setDescriptionTest() { // Test for set description
    Task task = new Task(); // Create new task
    task.setdescription(description); // Set description
    Assertions.assertEquals(description, task.getdescription()); // Check if task description is equal to the description given
  } 

  @Test
  void TaskIdTooLongTest() { // Test for task id too long
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class, 
      () -> new Task(longId) 
    );
  }

  @Test
  void setLongNameTest() { // Test for set long name
    Task task = new Task(); // Create new task
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class,
      () -> task.setName(longName)
    );
  }

  @Test
  void setLongDescriptionTest() { // Test for set long description
    Task task = new Task(); // Create new task
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class,
      () -> task.setdescription(longDescription)
    );
  }

  @Test
  void TaskIdNullTest() {  // Test for task id null
    Assertions.assertThrows(  // Check if exception is thrown
      IllegalArgumentException.class,
      () -> new Task(null) 
    ); 
  }

  @Test
  void TaskNameNullTest() { // Test for task name null
    Task task = new Task(); // Create new task
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class,
      () -> task.setName(null)
    );
  }

  @Test
  void TaskDescriptionNullTest() { // Test for task description null
    Task task = new Task(); // Create new task
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class,
      () -> task.setdescription(null)
    );
  }
}
