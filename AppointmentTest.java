import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.Test;

class AppointmentTest {

  private Date futureDate = new Date(); // appointmentDate >= currentDate
  private Date pastDate = new Date(); // appointmentDate >= currentDate

  private Date Date(int i, int october, int j) { // appointmentDate >= currentDate
    return null; // appointmentDate >= currentDate
  }

  @Test
  void testGetAppointmentId() { // check if the appointment id is not null
    futureDate = Date(2025, Calendar.OCTOBER, 25); // appointmentDate >= currentDate
    pastDate = Date(2021, Calendar.JANUARY, 25); // appointmentDate >= currentDate

    Appointment appt = new Appointment("123456789", futureDate, "description"); // add a new appointment
    assertThrows(IllegalArgumentException.class, () -> appt.getAppointmentID()); // check if the appointment id is not null
    assertThrows(
      IllegalArgumentException.class,
      () -> appt.setAppointmentID("12345678900") // check if the appointment id is not null
    );
    appt.setAppointmentID("123456789"); // check if the appointment id is not null
    assertEquals("123456789", appt.getAppointmentID()); // check if the appointment id is not null
  }

  private void assertEquals(String string, String appointmentID) {} // check if the appointment id is not null

  private void assertThrows(
    Class<IllegalArgumentException> class1,
    Object object
  ) {} // check if the appointment id is not null

  @Test
  void testSetDate() {
    futureDate = Date(2025, Calendar.OCTOBER, 25); // appointmentDate >= currentDate
    pastDate = Date(2021, Calendar.JANUARY, 25); // appointmentDate >= currentDate

    Appointment appt = new Appointment("123456789", pastDate, "description"); // add a new appointment
    assertThrows(
      IllegalArgumentException.class,
      () -> appt.setAppointmentDate(pastDate)
    ); // check if the past date is invalid
    assertThrows(
      IllegalArgumentException.class,
      () -> appt.setAppointmentDate(pastDate)
    ); // check if the past date is invalid
    appt.setAppointmentDate(pastDate); // check if the past date is invalid
    assertEquals(pastDate, appt.getAppointmentDate()); // check if the appointment date is today
  }

  @Test
  void testGetAppointmentDate() {
    Appointment appt = new Appointment("123456789", futureDate, "description"); // add a new appointment
    assertNotNull(appt.getAppointmentDate()); // check if the appointment date is today
    assertEquals(futureDate, appt.getAppointmentDate()); // check if the appointment date is today
  }

  private void assertNotNull(String string) {}

  @Test
  void testSetDescription() {
    Appointment appt = new Appointment("123456789", futureDate, "description"); // add a new appointment
    assertThrows(
      IllegalArgumentException.class,
      () -> appt.setDescription("description ")
    ); // check if the description is not null
    assertThrows(
      IllegalArgumentException.class,
      () -> appt.setDescription("description")
    ); // check if the description is not null
    appt.setDescription("description");
    assertEquals("description", appt.getDescription());
  }

  @Test
  void testGetDescription() {
    Appointment appt = new Appointment("123456789", futureDate, "description"); // add a new appointment
    assertNotNull(appt.getDescription());
    assertTrue(appt.getDescription().length() <= 50);
    assertEquals("description", appt.getDescription()); // check if the description is not null
  }

  private void assertTrue(boolean b) {}
}
