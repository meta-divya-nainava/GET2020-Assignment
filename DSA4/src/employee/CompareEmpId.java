package employee;

import java.util.Comparator;

public class CompareEmpId implements Comparator<Employee> {
	/**
	 * method to compare employee based on employee EmpId
	 */
	@Override
	public int compare(Employee employee1, Employee employee2) {
		if(employee1.getEmpId() < employee2.getEmpId()) {
			return -1;
		} else if(employee1.getEmpId() > employee2.getEmpId()) {
			return 1;
		} else {
			return 0;
		}
	}
}