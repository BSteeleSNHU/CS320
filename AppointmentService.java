import java.util.*;

public class AppointmentService { 

  private final List<Appointment> listOfAppointment = new ArrayList<>(); // list of appointments

  private String newUniqueId() {
    return UUID // generate a new unique id
      .randomUUID() // generate a new unique id
      .toString() // generate a new unique id
      .substring(0, Math.min(toString().length(), 10)); // generate a new unique id
  }

  public void addAppointment(Date date, String description) {
    Appointment appt = new Appointment(newUniqueId(), date, description); // create a new appointment
    listOfAppointment.add(appt); // add the new appointment to the list of appointments
  }

  public void deleteAppointment(String id) throws Exception {
    listOfAppointment.remove(searchForAppointment(id)); // remove the appointment from the list of appointments
  }

  protected List<Appointment> getAppointmentList() {
    return listOfAppointment; // return the list of appointments
  }

  private Appointment searchForAppointment(String id) throws Exception { // search for an appointment
    int index = 0; // index of the appointment 
    while (index < listOfAppointment.size()) { // while the index is less than the size of the list of appointments
      if (id.equals(listOfAppointment.get(index).getAppointmentID())) { // if the id is equal to the appointment id
        return listOfAppointment.get(index); // return the appointment
      } 
      index++; // increment the index
    }
    throw new Exception("Error"); // throw an exception
  }
}
