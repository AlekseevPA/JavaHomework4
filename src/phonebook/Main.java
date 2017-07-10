package phonebook;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		int count = 10000;
		ArrayList<Contact> contactsList = new ArrayList<>(); // список
		TreeSet<Contact> contactsSet = new TreeSet<>(Contact.contactComparator); // множество

		TreeMap<Integer, Contact> contactsMap = new TreeMap<>(); // карта
		TreeMap<String, Integer> counts = new TreeMap<>();

		Random rng = new Random();
		int length = 11;
		String characters = "0123456789";

		for (int i = 0; i < count; i++) {
			Phone p = new Phone(randomPhone(rng, characters, length));
			Contact c = new Contact("ФИО", p);
			appendRandom(rng, contactsList, c);
			contactsList.add(c);
			contactsSet.add(c);
			contactsMap.put(new Integer(i), c);
		}

		// обходим в обратном порядке список
		resetCounts(contactsList, counts);

		long startTime = System.currentTimeMillis();
		long stopTime = 0;

		ListIterator<Contact> li = contactsList.listIterator(contactsList.size());

		while (li.hasPrevious()) {
			Contact c = li.previous();
			appendCounts(c, counts);
		}

		stopTime = System.currentTimeMillis();
		System.out.printf("ArrayList: %d ms\n", stopTime - startTime);

		// обходим массив
		resetCounts(contactsList, counts);
		startTime = System.currentTimeMillis();

		Contact[] contactsArray = contactsList.toArray(new Contact[contactsList.size()]);

		for (int i = contactsArray.length - 1; i >= 0; i--) {
			appendCounts(contactsArray[i], counts);
		}

		stopTime = System.currentTimeMillis();
		System.out.printf("Array: %d ms\n", stopTime - startTime);

		// обходим множество

		resetCounts(contactsList, counts);
		startTime = System.currentTimeMillis();

		for (Contact c : contactsSet.descendingSet()) {
			appendCounts(c, counts);
		}

		stopTime = System.currentTimeMillis();
		System.out.printf("TreeSet: %d ms\n", stopTime - startTime);

		// обходим карту
		resetCounts(contactsList, counts);
		startTime = System.currentTimeMillis();

		for (Entry<Integer, Contact> entry : contactsMap.entrySet()) {
			appendCounts(entry.getValue(), counts);
		}

		stopTime = System.currentTimeMillis();
		System.out.printf("TreeMap: %d ms\n", stopTime - startTime);

	}

	public static void resetCounts(ArrayList<Contact> contactsList, TreeMap<String, Integer> counts) {
		for (Contact c : contactsList) {
			counts.put(c.getPhone().getPhone(), 0);
		}
	}

	public static void appendCounts(Contact contact, TreeMap<String, Integer> counts) {
		for (Contact c : contact.getRelatedContacts()) {
			String key = c.getPhone().getPhone();
			counts.put(key, counts.get(key) + 1);
		}
	}

	public static String randomPhone(Random rng, String characters, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return "+7" + new String(text);
	}

	public static void appendRandom(Random rng, ArrayList<Contact> contactsList, Contact contact) {
		if (contactsList.size() > 0) {
			int count = rng.nextInt(contactsList.size());
			count = count > 100 ? 100 : count;
			while (--count > 0) {
				contact.addRelatedContact(contactsList.get(rng.nextInt(contactsList.size())));
			}
		}
	}

}
