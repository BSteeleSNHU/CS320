import java.util.*;

public class Appointment { // Appointment class

  private String appointmentId; // appointment id
  private Date appointmentDate; // appointment date
  private String description; // description

  Appointment(String aid, Date d, String descript) {
    Date today = new Date(); // today's date

    if (aid == null || aid.length() > 10) { // if the appointment id is null or the length of the appointment id is greater than 10
      throw new IllegalArgumentException(
        "Error" // throw an exception
      ); 
    }
    
    if (d == null) { // if the appointment date is null
      throw new IllegalArgumentException("Error"); // throw an exception
    } else if (d.before(today)) { // if the appointment date is before today
      throw new IllegalArgumentException( // throw an exception
        "Error" // throw an exception
      );
    }

    if (descript == null || descript.length() > 50) { 
      throw new IllegalArgumentException( // throw an exception
        "Error" // throw an exception
      );    
    }
    this.appointmentId = aid; // set the appointment id
    this.appointmentDate = d; // set the appointment date
    this.description = descript; // set the description
  }

  public String getAppointmentID() {
    return appointmentId; // return the appointment id
  }

  public Date getAppointmentDate() {
    return appointmentDate; // return the appointment date
  }

  public String getDescription() {
    return description; // return the description
  }

  //setters
  public void setAppointmentID(String aid) { // set the appointment id
    if (aid == null || aid.length() > 10) { // if the appointment id is null or the length of the appointment id is greater than 10
      throw new IllegalArgumentException(
        "Error" // throw an exception
      );
    } else {
      this.appointmentId = aid; // set the appointment id
    }
  }

  public void setAppointmentDate(Date d) { // set the appointment date
    Date today = new Date(); // today's date
    if (d == null) { // if the appointment date is null
      throw new IllegalArgumentException("Error"); // throw an exception
    } else if (d.before(today)) { // if the appointment date is before today
      throw new IllegalArgumentException( // throw an exception
        "Error" // throw an exception
      );
    } else { // if the appointment date is after today
      this.appointmentDate = d; // set the appointment date
    }
  }
 
  public void setDescription(String descript) { // set the description
    if (descript == null || descript.length() > 50) { // if the description is null or the length of the description is greater than 50
      throw new IllegalArgumentException( // throw an exception
        "Error" // throw an exception
      );
    } else { // if the description is not null
      this.description = descript; // set the description
    } 
  }
}
