import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

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
  void contactTest() {
    Contact contact = new Contact();
    assertAll( // assert all
      () -> assertEquals("", contact.getId()), // contact id
      () -> assertEquals("", contact.getfName()), // contact first name
      () -> assertEquals("", contact.getlName()), // contact last name
      () -> assertEquals("", contact.getphoneNum()), // contact phone number
      () -> assertEquals("", contact.getstreetAddress()) // contact street address
    );
  }

  @Test
  void idContactConstructorTest() {
    Contact contact = new Contact(idContact);
    assertAll(
      "constructor one",
      () -> assertEquals(idContact, contact.getId()),
      () -> assertEquals("", contact.getfName()),
      () -> assertEquals("", contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void idContactAndfNameConstructorTest() {
    Contact contact = new Contact(idContact, fNameTest);
    assertAll(
      "constructor two",
      () -> assertEquals(idContact, contact.getId()),
      () -> assertEquals(fNameTest, contact.getfName()),
      () -> assertEquals("", contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void idContactAndFullNameConstructorTest() {
    Contact contact = new Contact(idContact, fNameTest, lNameTest);
    assertAll(
      "constructor three",
      () -> assertEquals(idContact, contact.getId()),
      () -> assertEquals(fNameTest, contact.getfName()),
      () -> assertEquals(lNameTest, contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void idContactFullNamephoneNumConstructorTest() {
    Contact contact = new Contact(
      idContact,
      fNameTest,
      lNameTest,
      phoneNumTest
    );
    assertAll(
      "constructor four",
      () -> assertEquals(idContact, contact.getId()),
      () -> assertEquals(fNameTest, contact.getfName()),
      () -> assertEquals(lNameTest, contact.getlName()),
      () -> assertEquals(phoneNumTest, contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(
      idContact,
      fNameTest,
      lNameTest,
      phoneNumTest,
      streetAddressTest
    );
    assertAll(
      "constructor all",
      () -> assertEquals(idContact, contact.getId()),
      () -> assertEquals(fNameTest, contact.getfName()),
      () -> assertEquals(lNameTest, contact.getlName()),
      () -> assertEquals(phoneNumTest, contact.getphoneNum()),
      () -> assertEquals(streetAddressTest, contact.getstreetAddress())
    );
  }

  @Test
  void updatefNameTest() {
    Contact contact = new Contact();
    contact.updatefName(fNameTest);
    assertAll(
      "first name",
      () -> assertEquals(fNameTest, contact.getfName()),
      () -> assertEquals("", contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void updatelNameTest() {
    Contact contact = new Contact();
    contact.updatelName(lNameTest);
    assertAll(
      "last name",
      () -> assertEquals("", contact.getfName()),
      () -> assertEquals(lNameTest, contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void updatephoneNumTest() {
    Contact contact = new Contact();
    contact.updatephoneNum(phoneNumTest);
    assertAll(
      "phone number",
      () -> assertEquals("", contact.getfName()),
      () -> assertEquals("", contact.getlName()),
      () -> assertEquals(phoneNumTest, contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }

  @Test
  void updatestreetAddressTest() {
    Contact contact = new Contact();
    contact.updatestreetAddress(streetAddressTest);
    assertAll(
      "street address",
      () -> assertEquals("", contact.getfName()),
      () -> assertEquals("", contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals(streetAddressTest, contact.getstreetAddress())
    );
  }

  @Test
  void updateidContactTest() {
    Contact contact = new Contact();
    contact.updateidContact(idContact);
    assertAll(
      "contact ID",
      () -> assertEquals(idContact, contact.getId()),
      () -> assertEquals("", contact.getfName()),
      () -> assertEquals("", contact.getlName()),
      () -> assertEquals("", contact.getphoneNum()),
      () -> assertEquals("", contact.getstreetAddress())
    );
  }
}
