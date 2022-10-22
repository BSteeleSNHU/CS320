import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private List<Contact> contactList = new ArrayList<>(); // create contact list

  {
    UUID 
      .randomUUID() // random id
      .toString() // convert to string
      .substring(0, Math.min(toString().length(), 10)); // substring
  }

  public void newContact() { // new contact
    Contact contact = new Contact(newUniqueId()); // create new contact
    contactList.add(contact); // add contact to list
  }

  public void newContact(String fName) { // new contact, first name
    Contact contact = new Contact(newUniqueId(), fName); // create new contact
    contactList.add(contact); // add contact to list
  }

  public void newContact(String fName, String lName) { // new contact, first name, last name
    Contact contact = new Contact(newUniqueId(), fName, lName); // create new contact
    contactList.add(contact); // add contact to list
  }

  public void newContact( // new contact, first name, last name, phone number
    String fName,
    String lName,
    String phoneNum
  ) {
    Contact contact = new Contact( // create new contact
      newUniqueId(),
      fName,
      lName,
      phoneNum
    );
    contactList.add(contact); // add contact to list
  }

  public void newContact( // new contact, first name, last name, phone number, street address
    String fName,
    String lName,
    String phoneNum,
    String streetAddress
  ) {
    Contact contact = new Contact( // create new contact
      newUniqueId(), 
      fName,
      lName,
      phoneNum,
      streetAddress
    );
    contactList.add(contact); // add contact to list
  }

  public void deleteContact(String id) throws Exception { // delete contact
    contactList.remove(searchForContact(id)); // remove contact from list
  }

  public void updatefName(String id, String fName) throws Exception { // update first name
    searchForContact(id).updatefName(fName); // update first name
  }

  public void updatelName(String id, String lName) throws Exception { // update last name
    searchForContact(id).updatelName(lName); // update last name
  }

  public void updatephoneNum(String id, String phoneNum) // update phone number
    throws Exception {  
    searchForContact(id).updatephoneNum(phoneNum);  // update phone number
  }

  public void updatestreetAddress(String id, String streetAddress) throws Exception { // update street address
    searchForContact(id).updatestreetAddress(streetAddress); // update street address
  }

  protected List<Contact> getContactList() { // get contact list
    return contactList; // return contact list
  }

  private String newUniqueId() { // new unique id
    return ( // return
      UUID 
        .randomUUID()
        .toString()
        .substring(0, Math.min(toString().length(), 10))
    ); // return
  }

  private Contact searchForContact(String id) throws Exception { // search for contact
    int index = 0; // index
    while (index < contactList.size()) { // while index is less than size of list
      if (id.equals(contactList.get(index).getidContact())) { // if id equals id contact
        return contactList.get(index); // return contact
      }
      index++; // increment index
    }
    throw new Exception("The Task does not exist!"); // throw exception
  }
}
