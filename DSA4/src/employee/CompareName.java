package employee;

import java.util.Comparator;

public class CompareName implements Comparator<Employee> {
	/**
	 * method to compare employee based on employee name
	 */
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getName().compareTo(employee2.getName());
	}
}