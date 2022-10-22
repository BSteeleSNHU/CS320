public class Contact {

  private static final int CONTACT_PHONENUM_LENGTH = 10; // set phone number length
  private static final byte CONTACT_ID_LENGTH = 10; // set contact id length
  private static final byte CONTACT_FNAME_LENGTH = 10; // set first name length
  private static final byte CONTACT_LNAME_LENGTH = 10; // set last name length
  private static final byte CONTACT_ADDRESS_LENGTH = 30; // set street address length
  private static final String INITIALIZER = "INITIAL"; // set initial
  private static final String INITIALIZER_NUM = "4690009999"; // set initial num
  private String idContact; // set id contact
  private String fName; // set first name
  private String lName; // set last name
  private String phoneNum; // set phone number
  private String streetAddress; // set street address

  Contact() { // initialize
    this.idContact = INITIALIZER; // initialize
    this.fName = INITIALIZER; // initialize
    this.lName = INITIALIZER; // initialize
    this.phoneNum = INITIALIZER_NUM; // initialize
    this.streetAddress = INITIALIZER; //initialize
  }

  Contact(String idContact) { // contact, id initializer
    updateidContact(idContact); // idContact
    this.fName = INITIALIZER; // initialize
    this.lName = INITIALIZER; // initialize
    this.phoneNum = INITIALIZER_NUM; // initialize
    this.streetAddress = INITIALIZER; // initialize
  }

  Contact(String idContact, String fName) { // contact, id, first name initializer
    updateidContact(idContact); // idContact
    updatefName(fName); // fName
    this.lName = INITIALIZER; // initialize
    this.phoneNum = INITIALIZER_NUM; // initialize
    this.streetAddress = INITIALIZER; // initialize
  }

  Contact(String idContact, String fName, String lName) { // contact,id, first name, last name initializer
    updateidContact(idContact); // idContact
    updatefName(fName); // fName
    updatelName(lName); // lName
    this.phoneNum = INITIALIZER_NUM; // initialize
    this.streetAddress = INITIALIZER; // initialize
  }

  Contact(String idContact, String fName, String lName, String phoneNum) { // contact, id, first name, last name, phone number initializer
    updateidContact(idContact); // idContact
    updatefName(fName); // fName
    updatelName(lName); // lName
    updatephoneNum(phoneNum); // phoneNum
    this.streetAddress = INITIALIZER;  // initialize
  }

  Contact( 
    String idContact,
    String fName,
    String lName,
    String phoneNum,
    String streetAddress
  ) {
    updateidContact(idContact); // idContact
    updatefName(fName); // fName
    updatelName(lName); // lName
    updatephoneNum(phoneNum); // phoneNum
    updatestreetAddress(streetAddress); // streetAddress
  }

  protected final String getidContact() { // get id contact
    return idContact; // return id contact
  }

  protected final String getfName() { // get first name
    return fName; // return first name
  }

  protected final String getlName() { // get last name
    return lName; // return last name
  }

  protected final String getphoneNum() { // get phone number
    return phoneNum; // return phone number
  }

  protected final String getstreetAddress() { // get street address
    return streetAddress; // return street address
  }

  protected void updatefName(String fName) { // update first name
    if (fName == null) { // if first name is null
      throw new IllegalArgumentException("Cannot be empty"); // throw exception
    } else if (fName.length() > CONTACT_FNAME_LENGTH) { // if first name is greater than length
      throw new IllegalArgumentException( // throw exception
        "Cannot exceed length of " + CONTACT_FNAME_LENGTH + " letters" // throw exception
      ); 
    } else { // else
      this.fName = fName; // set first name
    }
  }

  protected void updatelName(String lName) { // update last name
    if (lName == null) { // if last name is null
      throw new IllegalArgumentException("Cannot be empty"); // throw exception
    } else if (lName.length() > CONTACT_LNAME_LENGTH) { // if last name is greater than length
      throw new IllegalArgumentException( // throw exception
        "Cannot exceed length of " + CONTACT_LNAME_LENGTH + " letters" // throw exception
      );
    } else { // else
      this.lName = lName; // set last name
    }
  }

  protected void updatephoneNum(String phoneNum) { // update phone number
    String regex = "[0-9]+"; // set regex
    if (phoneNum == null) { // if phone number is null
      throw new IllegalArgumentException("Cannot be empty."); // throw exception
    } else if (phoneNum.length() != CONTACT_PHONENUM_LENGTH) { // if phone number is not equal to length
      throw new IllegalArgumentException( // throw exception
        "Invalid input, match number to " + CONTACT_PHONENUM_LENGTH + " digits." // throw exception
      );
    } else if (!phoneNum.matches(regex)) { // if phone number does not match regex
      throw new IllegalArgumentException("Invalid input"); // throw exception
    } else { // else
      this.phoneNum = phoneNum; // set phone number
    }
  }

  protected void updatestreetAddress(String streetAddress) { // update street address
    if (streetAddress == null) { // if street address is null
      throw new IllegalArgumentException("Cannot be empty"); // throw exception
    } else if (streetAddress.length() > CONTACT_ADDRESS_LENGTH) { // if street address is greater than length
      throw new IllegalArgumentException( // throw exception
        "Cannot exceed " + CONTACT_ADDRESS_LENGTH + " characters" // throw exception
      );
    } else { // else
      this.streetAddress = streetAddress; // set street address
    }
  }

  protected void updateidContact(String idContact) {  // update id contact
    if (idContact == null) { // if id contact is null
      throw new IllegalArgumentException("Cannot be empty"); // throw exception
    } else if (idContact.length() > CONTACT_ID_LENGTH) { // if id contact is greater than length
      throw new IllegalArgumentException( // throw exception
        "Cannot exceed " + CONTACT_ID_LENGTH + " characters" // throw exception
      );
    } else {  // else
      this.idContact = idContact; // set id contact
    }
  }
}
