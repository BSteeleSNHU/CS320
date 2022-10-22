import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

  protected String idContact, fNameTest, lNameTest, phoneNumTest, streetAddressTest;
  protected String tooLongidContact, tooLongfName, tooLonglName, tooLongphoneNum, tooShortphoneNum, tooLongstreetAddress;

  @BeforeEach
  void setUp() {
    idContact = "1234567890";
    fNameTest = "Sally";
    lNameTest = "Kane";
    phoneNumTest = "1234567890";
    streetAddressTest = "1234 Main St";
    tooLongidContact = "12345678901";
    tooLongfName = "Sally Smith Johnson The Third";
    tooLonglName = "Sally Last Name Smith";
    tooLongphoneNum = "12345678901";
    tooShortphoneNum = "123456789";
    tooLongstreetAddress = "1234 Main St Apt 1234567890";
  }

  @Test
  void newContactTest() { // new contact test
    ContactService service = new ContactService(); // new contact service
    service.newContact(); // new contact
    assertAll( // assert all
      () -> assertEquals(1, service.getContactList().size()), // contact list size
      () -> assertEquals("1", service.getContactList().get(0).getId()), // contact id
      () -> assertEquals("", service.getContactList().get(0).getfName()), // contact first name
      () -> assertEquals("", service.getContactList().get(0).getlName()), // contact last name
      () -> assertEquals("", service.getContactList().get(0).getphoneNum()), // contact phone number
      () -> assertEquals("", service.getContactList().get(0).getstreetAddress()) // contact street address
    );
    service.newContact(fNameTest);
    assertAll( // assert all
      () -> assertEquals(2, service.getContactList().size()), // contact list size
      () -> assertEquals("2", service.getContactList().get(1).getId()), // contact id
      () -> assertEquals(fNameTest, service.getContactList().get(1).getfName()), // contact first name
      () -> assertEquals("", service.getContactList().get(1).getlName()), // contact last name
      () -> assertEquals("", service.getContactList().get(1).getphoneNum()), // contact phone number
      () -> assertEquals("", service.getContactList().get(1).getstreetAddress()) // contact street address
    );
    service.newContact(fNameTest, lNameTest);
    assertAll( // assert all
      () -> assertEquals(3, service.getContactList().size()), // contact list size
      () -> assertEquals("3", service.getContactList().get(2).getId()), // contact id
      () -> assertEquals(fNameTest, service.getContactList().get(2).getfName()), // contact first name
      () -> assertEquals(lNameTest, service.getContactList().get(2).getlName()), // contact last name
      () -> assertEquals("", service.getContactList().get(2).getphoneNum()), // contact phone number
      () -> assertEquals("", service.getContactList().get(2).getstreetAddress()) // contact street address
    );
    service.newContact(fNameTest, lNameTest, phoneNumTest);
    assertAll( // assert all
      () -> assertEquals(4, service.getContactList().size()), // contact list size
      () -> assertEquals("4", service.getContactList().get(3).getId()), // contact id
      () -> assertEquals(fNameTest, service.getContactList().get(3).getfName()), // contact first name
      () -> assertEquals(lNameTest, service.getContactList().get(3).getlName()), // contact last name
      () ->
        assertEquals(
          phoneNumTest,
          service.getContactList().get(3).getphoneNum()
        ), // contact phone number
      () -> assertEquals("", service.getContactList().get(3).getstreetAddress()) // contact street address
    );
    service.newContact(fNameTest, lNameTest, phoneNumTest, streetAddressTest);
    assertAll( // assert all
      () -> assertEquals(5, service.getContactList().size()), // contact list size
      () -> assertEquals("5", service.getContactList().get(4).getId()), // contact id
      () -> assertEquals(fNameTest, service.getContactList().get(4).getfName()), // contact first name
      () -> assertEquals(lNameTest, service.getContactList().get(4).getlName()), // contact last name
      () ->
        assertEquals(
          phoneNumTest,
          service.getContactList().get(4).getphoneNum()
        ), // contact phone number
      () ->
        assertEquals(
          streetAddressTest,
          service.getContactList().get(4).getstreetAddress()
        ) // contact street address
    );
  }

  @Test
  void deleteContactTest() { // delete contact test
    ContactService service = new ContactService(); // new contact service
    service.newContact(); // new contact
    assertThrows(Exception.class, () -> service.deleteContact(idContact)); // delete contact
    assertAll(
      () ->
        service.deleteContact(service.getContactList().get(0).getidContact()) // delete contact
    );
  }

  @Test
  void updatefNameTest() throws Exception { // update first name test
    ContactService service = new ContactService(); // new contact service
    service.newContact(); // new contact
    service.updatefName( // update first name
      service.getContactList().get(0).getidContact(), // contact id
      fNameTest // first name
    );
    assertEquals(fNameTest, service.getContactList().get(0).getfName());
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatefName(
          service.getContactList().get(0).getidContact(),
          tooLongfName
        )
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatefName(
          service.getContactList().get(0).getidContact(),
          null
        )
    );
    assertThrows(
      Exception.class,
      () -> service.updatefName(idContact, fNameTest)
    );
  }

  @Test
  void updatelNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatelName(
      service.getContactList().get(0).getidContact(),
      lNameTest
    );
    assertEquals(lNameTest, service.getContactList().get(0).getlName());
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatelName(
          service.getContactList().get(0).getidContact(),
          tooLonglName
        )
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatelName(
          service.getContactList().get(0).getidContact(),
          null
        )
    );
    assertThrows(
      Exception.class,
      () -> service.updatelName(idContact, lNameTest)
    );
  }

  @Test
  void updatephoneNumTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatephoneNum(
      service.getContactList().get(0).getidContact(),
      phoneNumTest
    );
    assertEquals(phoneNumTest, service.getContactList().get(0).getphoneNum());
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatephoneNum(
          service.getContactList().get(0).getidContact(),
          tooLongphoneNum
        )
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatephoneNum(
          service.getContactList().get(0).getidContact(),
          tooShortphoneNum
        )
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatephoneNum(
          service.getContactList().get(0).getidContact(),
          idContact
        )
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatephoneNum(
          service.getContactList().get(0).getidContact(),
          null
        )
    );
    assertThrows(
      Exception.class,
      () -> service.updatephoneNum(idContact, lNameTest)
    );
  }

  @Test
  void updatestreetAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatestreetAddress(
      service.getContactList().get(0).getidContact(),
      streetAddressTest
    );
    assertEquals(
      streetAddressTest,
      service.getContactList().get(0).getstreetAddress()
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatestreetAddress(
          service.getContactList().get(0).getidContact(),
          tooLongstreetAddress
        )
    );
    assertThrows(
      IllegalArgumentException.class,
      () ->
        service.updatestreetAddress(
          service.getContactList().get(0).getidContact(),
          null
        )
    );
    assertThrows(
      Exception.class,
      () -> service.updatestreetAddress(idContact, streetAddressTest)
    );
  }
}
