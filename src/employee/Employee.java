package employee;

import java.util.Collection;
import java.util.Iterator;

public class Employee {
	protected String firstName; // имя
	protected String lastName; // фамилия
	protected String middleName; // отчество
	protected int workAge; // стаж работы

	public Employee(String firstName, String lastName, String middleName, int workAge) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.workAge = workAge;
	}

	public static void printEmployee(Collection<Employee> employees, int workAge) {
		Iterator<Employee> it = employees.iterator();
		System.out.println("Все работники, где стаж = " + workAge);
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getWorkAge() == workAge) {
				System.out.println(e);
			}
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", lastName, firstName, middleName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getWorkAge() {
		return workAge;
	}

	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}

}
