package phonebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Contact {
	/**
	 * Сравнение двух контактов
	 */
	public static Comparator<Contact> contactComparator = new Comparator<Contact>() {

		@Override
		public int compare(Contact c1, Contact c2) {
			return c1.hashCode() - c2.hashCode();
		}

	};

	protected String name; // имя контакта
	protected Phone phone; // телефон
	protected TreeSet<Contact> relatedContacts; // контакты

	public Contact(String name, Phone phone) {
		this.name = name;
		this.phone = phone;
		this.relatedContacts = new TreeSet<>(contactComparator);
	}

	public void addRelatedContact(Contact contact) {
		this.relatedContacts.add(contact);
	}

	public String getName() {
		return name;
	}

	public Phone getPhone() {
		return phone;
	}

	public TreeSet<Contact> getRelatedContacts() {
		return relatedContacts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public void setRelatedContacts(TreeSet<Contact> relatedContacts) {
		this.relatedContacts = relatedContacts;
	}

	@Override
	public int hashCode() {
		return this.phone.hashCode();
		// return 1;
	}

	@Override
	public String toString() {
		return this.phone.getPhone() + " => " + Arrays.toString(this.relatedContacts.toArray());
	}
}
