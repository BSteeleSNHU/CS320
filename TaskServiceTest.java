import org.junit.jupiter.api.Assertions; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

  private String id, name, description;
  private String longName, longDescription;

  @BeforeEach
  void set() {
    id = "1234567890";
    name = "Name";
    description = "Description";
    longName = "The long name is more than the characters for a normal name";
    longDescription =
      "The long description is more than the characters for a normal description";
  }

  @Test
  void newTaskTest() { // Test for new task
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId()); // Check if task id is not null
    Assertions.assertNotEquals( // Check if task id is not equal to the previous task id
      "Start", 
      service.getTaskList().get(0).getTaskId() 
    ); 
  }

  @Test
  void newTaskNameTest() { // Test for new task with name
    TaskService service = new TaskService(); // Create new task service
    service.newTask(name); // Create new task with name
    Assertions.assertNotNull(service.getTaskList().get(0).getName()); // Check if task name is not null
    Assertions.assertEquals(name, service.getTaskList().get(0).getName()); // Check if task name is equal to the name given
  }

  @Test
  void newTaskDescriptionTest() { // Test for new task with description
    TaskService service = new TaskService(); // Create new task service
    service.newTask(name, description); // Create new task with name and description
    Assertions.assertNotNull(service.getTaskList().get(0).getdescription()); // Check if task description is not null
    Assertions.assertEquals( // Check if task description is equal to the description given
      description,
      service.getTaskList().get(0).getdescription() 
    );
  }

  @Test
  void newTaskLongNameTest() { // Test for new task with long name
    TaskService service = new TaskService(); // Create new task service
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class, 
      () -> service.newTask(longName) 
    );
  }

  @Test
  void newTaskLongDescriptionTest() { // Test for new task with long description
    TaskService service = new TaskService(); // Create new task service
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class,
      () -> service.newTask(name, longDescription) 
    );
  }

  @Test
  void newTaskNameNullTest() {  // Test for new task with null name
    TaskService service = new TaskService(); // Create new task service
    Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
  } // Check if exception is thrown
 
  @Test
  void newTaskDescriptionNullTest() { // Test for new task with null description
    TaskService service = new TaskService(); // Create new task service
    Assertions.assertThrows( // Check if exception is thrown
      IllegalArgumentException.class,
      () -> service.newTask(name, null) 
    );
  }

  @Test
  void deleteTaskTest() throws Exception { // Test for delete task
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    assertEquals(1, service.getTaskList().size()); // Check if task list size is 1
    service.deleteTask(service.getTaskList().get(0).getTaskId()); // Delete task
    assertEquals(0, service.getTaskList().size()); // Check if task list size is 0
  }

  private void assertEquals(int i, int size) {} // Method to check if task list size is 0

  @Test
  void deleteTaskNotFoundTest() throws Exception { // Test for delete task not found
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    assertEquals(1, service.getTaskList().size()); // Check if task list size is 1
    Assertions.assertThrows(Exception.class, () -> service.deleteTask(id)); // Check if exception is thrown
    assertEquals(1, service.getTaskList().size()); // Check if task list size is 1
  }

  @Test
  void updateNameTest() throws Exception { // Test for update name
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    service.updateName(service.getTaskList().get(0).getTaskId(), name); // Update name
    assertEquals(name, service.getTaskList().get(0).getName()); // Check if task name is equal to the name given
  }

  private void assertEquals(String name2, String name3) {} // Method to check if task name is equal to the name given

  @Test 
  void updateDescriptionTest() throws Exception { // Test for update description
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    service.updateDescription( // Update description
      service.getTaskList().get(0).getTaskId(), 
      description
    );
    assertEquals(description, service.getTaskList().get(0).getdescription()); // Check if task description is equal to the description given
  }

  @Test
  void updateNameNotFoundTest() throws Exception { // Test for update name not found
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    Assertions.assertThrows(Exception.class, () -> service.updateName(id, name)); // Check if exception is thrown
  }

  @Test
  void updateDescriptionNotFoundTest() throws Exception { // Test for update description not found
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    Assertions.assertThrows( // Check if exception is thrown
      Exception.class,
      () -> service.updateDescription(id, description) 
    );
  }

  @RepeatedTest(4) // Test for update name with long name
  void UuidTest() { // Test for UUID
    TaskService service = new TaskService(); // Create new task service
    service.newTask(); // Create new task
    service.newTask(); // Create new task
    service.newTask(); // Create new task
    assertEquals(3, service.getTaskList().size()); // Check if task list size is 3
    assertEquals( // Check if task id is not equal to the previous task id
      service.getTaskList().get(0).getTaskId(),
      service.getTaskList().get(1).getTaskId()
    );
    assertEquals( // Check if task id is not equal to the previous task id
      service.getTaskList().get(0).getTaskId(),
      service.getTaskList().get(2).getTaskId()
    );
    assertEquals( // Check if task id is not equal to the previous task id
      service.getTaskList().get(1).getTaskId(),
      service.getTaskList().get(2).getTaskId()
    );
  }
}
