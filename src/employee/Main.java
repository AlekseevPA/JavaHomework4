package employee;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

	public static void main(String[] args) {

		Collection<Employee> employees = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			employees.add(new Employee("FirstName" + i, "LastName" + i, "MiddleName" + i, i % 3 + 1));
		}
		
		
		Employee.printEmployee(employees, 1);
		Employee.printEmployee(employees, 2);
		Employee.printEmployee(employees, 3);
	}

}
