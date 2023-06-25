import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private String uniqueId;
  private List<Contact> contacts = new ArrayList<>();

  {
    uniqueId = UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newContact() {
    Contact contact = new Contact(newUniqueId());
    contacts.add(contact);
  }

  public void newContact(String firstname) {
    Contact contact = new Contact(newUniqueId(), firstname);
    contacts.add(contact);
  }

  public void newContact(String firstname, String lastname) {
    Contact contact = new Contact(newUniqueId(), firstname, lastname);
    contacts.add(contact);
  }

  public void newContact(String firstname, String lastname,
                         String phonenum) {
    Contact contact =
        new Contact(newUniqueId(), firstname, lastname, phonenum);
    contacts.add(contact);
  }

  public void newContact(String firstname, String lastname, String phonenum,
                         String address) {
    Contact contact =
        new Contact(newUniqueId(), firstname, lastname, phonenum, address);
    contacts.add(contact);
  }

  public void deleteContact(String id) throws Exception {
    contacts.remove(searchForContact(id));
  }

  public void updateFirstName(String id, String firstName) throws Exception {
    searchForContact(id).updateFirstName(firstName);
  }

  public void updateLastName(String id, String lastName) throws Exception {
    searchForContact(id).updateLastName(lastName);
  }

  public void updatePhoneNumber(String id, String phoneNum)
      throws Exception {
    searchForContact(id).updatePhoneNumber(phoneNum);
  }

  public void updateAddress(String id, String address) throws Exception {
    searchForContact(id).updateAddress(address);
  }

  protected List<Contact> getContactList() { return contacts; }

  private String newUniqueId() {
    return uniqueId = UUID.randomUUID().toString().substring(
               0, Math.min(toString().length(), 10));
  }

  private Contact searchForContact(String id) throws Exception {
    int index = 0;
    while (index < contacts.size()) {
      if (id.equals(contacts.get(index).getContactId())) {
        return contacts.get(index);
      }
      index++;
    }
    throw new Exception("The Task does not exist!");
  }
}