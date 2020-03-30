package employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
class TestEmployee {

	@Test
	void testCompareEmpId() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(new Employee(4, "John", "Udaipur"));
			employees.add(new Employee(5, "Anna", "Jaipur"));
			employees.add(new Employee(2, "Paul", "Pali"));
			employees.add(new Employee(1, "Mick", "Kota"));
			employees.add(new Employee(3, "Ben", "Ahemdabad"));
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			expectedOrder.add(employees.get(3));
			expectedOrder.add(employees.get(2));
			expectedOrder.add(employees.get(4));
			expectedOrder.add(employees.get(0));
			expectedOrder.add(employees.get(1));
			
			employees.sort(new CompareEmpId());
			assertTrue(expectedOrder.equals(employees));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testCompareName() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(new Employee(4, "John", "Udaipur"));
			employees.add(new Employee(5, "Anna", "Jaipur"));
			employees.add(new Employee(2, "Paul", "Pali"));
			employees.add(new Employee(1, "Mick", "Kota"));
			employees.add(new Employee(3, "Ben", "Ahemdabad"));
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			expectedOrder.add(employees.get(1));
			expectedOrder.add(employees.get(4));
			expectedOrder.add(employees.get(0));
			expectedOrder.add(employees.get(3));
			expectedOrder.add(employees.get(2));
			
			employees.sort(new CompareName());
			assertTrue(expectedOrder.equals(employees));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testUniqueEmpIdComplex() {
		try {
			Set<Employee> employees = new HashSet<Employee>();
			employees.add(new Employee(1, "John", "Udaipur"));
			employees.add(new Employee(1, "Anna", "Jaipur"));
			employees.add(new Employee(1, "Paul", "Pali"));
			employees.add(new Employee(2, "Mick", "Kota"));
			employees.add(new Employee(2, "Ben", "Ahemdabad"));
			assertEquals(employees.size(), 2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testUniqueEmpIdSimple() {
		try {
			Set<Employee> employees = new HashSet<Employee>();
			employees.add(new Employee(1, "John", "Udaipur"));
			employees.add(new Employee(2, "John", "Udaipur"));
			employees.add(new Employee(3, "John", "Udaipur"));
			employees.add(new Employee(4, "John", "Udaipur"));
			employees.add(new Employee(5, "John", "Udaipur"));
			
			assertEquals(employees.size(), 5);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}