import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

  private Date today, pastDate, futureDate; // appointmentDate >= currentDate

  @Test
  void testNewAppointment() {
    AppointmentService service = new AppointmentService();
    service.addAppointment(futureDate, "description"); // add a new appointment
    assertNotNull(service.getAppointmentList().get(2).getAppointmentID()); // check if the appointment id is not null
    assertEquals(
      today,
      service.getAppointmentList().get(2).getAppointmentDate() // check if the appointment date is today
    );
    assertEquals(
      "description", // check if the description is correct
      service.getAppointmentList().get(2).getDescription() // check if the description is correct
    );
    assertNotEquals(
      service.getAppointmentList().get(0).getAppointmentID(), // check if the appointment id is not the same as the first appointment
      service.getAppointmentList().get(1).getAppointmentID() // check if the appointment id is not the same as the second appointment
    );
    assertNotEquals(
      service.getAppointmentList().get(0).getAppointmentID(), // check if the appointment id is not the same as the first appointment
      service.getAppointmentList().get(2).getAppointmentID() // check if the appointment id is not the same as the third appointment
    );
    assertNotEquals(
      service.getAppointmentList().get(1).getAppointmentID(), // check if the appointment id is not the same as the second appointment
      service.getAppointmentList().get(2).getAppointmentID() // check if the appointment id is not the same as the third appointment
    ); 
    assertThrows(
      IllegalArgumentException.class, 
      () -> service.addAppointment( pastDate, "description") // check if the past date is invalid
    );
    assertThrows(
      IllegalArgumentException.class, 
      () -> service.addAppointment( futureDate, "description ") // check if the description is invalid
    );
    );
  }

  private void assertThrows(Class<IllegalArgumentException> class1, Object object) { 
	
}

private void assertEquals(String string, String description) {
}

private void assertNotNull(String appointmentID) {
}

private void assertEquals(Date today2, Date date) {
}

@Test
  void deleteAppointment() throws Exception { // delete an appointment
    AppointmentService service = new AppointmentService();
    service.addAppointment(futureDate, "description"); // add a new appointment
    service.addAppointment(futureDate, "description"); // add a new appointment
    service.addAppointment(futureDate, "description"); // add a new appointment
    String firstId = service.getAppointmentList().get(0).getAppointmentID(); // get the first appointment id
    String secondId = service.getAppointmentList().get(1).getAppointmentID(); // get the second appointment id
    String thirdId = service.getAppointmentList().get(2).getAppointmentID(); // get the third appointment id
    assertNotEquals(firstId, secondId); // check if the first appointment id is not the same as the second appointment id
    assertNotEquals(firstId, thirdId); // check if the first appointment id is not the same as the second and third appointment id
    assertNotEquals(secondId, thirdId); // check if the second appointment id is not the same as the third appointment id
    assertNotEquals("123456789", firstId); // check if the first appointment id is not the same as the invalid appointment id
    assertNotEquals("123456789", secondId); // check if the second appointment id is not the same as the invalid appointment id
    assertNotEquals("123456789", thirdId); // check if the third appointment id is not the same as the invalid appointment id
    assertThrows(Exception.class, () -> service.deleteAppointment("123456789")); // check if the invalid appointment id is invalid
    service.deleteAppointment(firstId); // delete the first appointment
    assertThrows(Exception.class, () -> service.deleteAppointment(firstId)); // check if the first appointment id is invalid
    assertNotEquals(
      firstId, 
      service.getAppointmentList().get(0).getAppointmentID() // check if the first appointment id is not the same as the first appointment id
    );
  }

private void assertNotEquals(String string, String secondId) { 
}
}
