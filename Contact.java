
public class Contact {

  private static final int CONTACT_PHONENUM_LENGTH = 10;
  private static final byte CONTACT_ID_LENGTH = 10;
  private static final byte CONTACT_FNAME_LENGTH = 10;
  private static final byte CONTACT_LNAME_LENGTH = 10;
  private static final byte CONTACT_ADDRESS_LENGTH = 30;
  private static final String DEFAULT = "DEFAULT";
  private static final String DEFAULT_NUM = "1223334444";
  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNum;
  private String address;

  Contact() {
    this.contactId = DEFAULT;
    this.firstName = DEFAULT;
    this.lastName = DEFAULT;
    this.phoneNum = DEFAULT_NUM;
    this.address = DEFAULT;
  }

  Contact(String contactId) {
    updateContactId(contactId);
    this.firstName = DEFAULT;
    this.lastName = DEFAULT;
    this.phoneNum = DEFAULT_NUM;
    this.address = DEFAULT;
  }

  Contact(String contactId, String firstName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    this.lastName = DEFAULT;
    this.phoneNum = DEFAULT_NUM;
    this.address = DEFAULT;
  }

  Contact(String contactId, String firstName, String lastName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    this.phoneNum = DEFAULT_NUM;
    this.address = DEFAULT;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNum) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNum);
    this.address = DEFAULT;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNum, String address) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNum);
    updateAddress(address);
  }

  protected final String getContactId() { return contactId; }

  protected final String getFirstName() { return firstName; }

  protected final String getLastName() { return lastName; }

  protected final String getPhoneNum() { return phoneNum; }

  protected final String getAddress() { return address; }

  protected void updateFirstName(String firstName) {
    if (firstName == null) {
      throw new IllegalArgumentException("First name cannot be empty");
    } else if (firstName.length() > CONTACT_FNAME_LENGTH) {
      throw new IllegalArgumentException("First name cannot be longer than " +
                                         CONTACT_FNAME_LENGTH + " characters");
    } else {
      this.firstName = firstName;
    }
  }

  protected void updateLastName(String lastName) {
    if (lastName == null) {
      throw new IllegalArgumentException("Last name cannot be empty");
    } else if (lastName.length() > CONTACT_LNAME_LENGTH) {
      throw new IllegalArgumentException("Last name cannot be longer than " +
                                         CONTACT_LNAME_LENGTH + " characters");
    } else {
      this.lastName = lastName;
    }
  }

  protected void updatePhoneNumber(String phoneNum) {
    String regex = "[0-9]+";
    if (phoneNum == null) {
      throw new IllegalArgumentException("Phone number cannot be empty.");
    } else if (phoneNum.length() != CONTACT_PHONENUM_LENGTH) {
      throw new IllegalArgumentException(
          "Phone number length invalid. Ensure it is " +
          CONTACT_PHONENUM_LENGTH + " digits.");
    } else if (!phoneNum.matches(regex)) {
      throw new IllegalArgumentException(
          "Phone number cannot have anything but numbers");
    } else {
      this.phoneNum = phoneNum;
    }
  }

  protected void updateAddress(String address) {
    if (address == null) {
      throw new IllegalArgumentException("Address cannot be empty");
    } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
      throw new IllegalArgumentException("Address cannot be longer than " +
                                         CONTACT_ADDRESS_LENGTH +
                                         " characters");
    } else {
      this.address = address;
    }
  }

  protected void updateContactId(String contactId) {
    if (contactId == null) {
      throw new IllegalArgumentException("Contact ID cannot be empty");
    } else if (contactId.length() > CONTACT_ID_LENGTH) {
      throw new IllegalArgumentException("Contact ID cannot be longer than " +
                                         CONTACT_ID_LENGTH + " characters");
    } else {
      this.contactId = contactId;
    }
  }
}