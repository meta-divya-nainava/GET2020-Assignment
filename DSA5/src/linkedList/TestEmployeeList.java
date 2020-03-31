package linkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestEmployeeList {
	LinkedList linkedList=new LinkedList();
	@Test
	public void TestSimpleEmployeeList()
	{
		try {
		
		linkedList.insertNode(new Employee(1,"john",22,2000));
		linkedList.insertNode(new Employee(2,"paul",23,2500));
		linkedList.insertNode(new Employee(3,"anna",24,3500));
		linkedList.insertNode(new Employee(4,"peter",26,1900));
		linkedList.insertNode(new Employee(5,"joey",25,5000));
		linkedList.sortEmployee();
		List<Employee> expectedSalaryList=new ArrayList<>();
		expectedSalaryList.add(new Employee(5,"joey",25,5000));
		expectedSalaryList.add(new Employee(3,"anna",24,3500));
		expectedSalaryList.add(new Employee(2,"paul",23,2500));
		expectedSalaryList.add(new Employee(1,"john",22,2000));
		expectedSalaryList.add(new Employee(4,"peter",26,1900));
		List<Employee> actualSalaryList=linkedList.getsortedSalaryList();
		assertTrue(expectedSalaryList.equals(actualSalaryList));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void TestSimpleEmployeeListWithSameSalary()
	{
		try {
		linkedList.insertNode(new Employee(1,"john",22,2000));
		linkedList.insertNode(new Employee(2,"paul",23,2000));
		linkedList.insertNode(new Employee(3,"anna",24,2000));
		linkedList.insertNode(new Employee(4,"peter",26,2000));
		linkedList.insertNode(new Employee(5,"joey",25,2000));
		linkedList.sortEmployee();
		List<Employee> expectedSalaryList=new ArrayList<>();
		expectedSalaryList.add(new Employee(1,"john",22,2000));
		expectedSalaryList.add(new Employee(2,"paul",23,2000));
		expectedSalaryList.add(new Employee(3,"anna",24,2000));
		expectedSalaryList.add(new Employee(5,"joey",25,2000));
		expectedSalaryList.add(new Employee(4,"peter",26,2000));
		List<Employee> actualSalaryList=linkedList.getsortedSalaryList();
		assertTrue(expectedSalaryList.equals(actualSalaryList));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void TestComplexEmployeeListWithSameSalary()
	{
		try {
		linkedList.insertNode(new Employee(1,"john",22,-2000));
		linkedList.insertNode(new Employee(2,"paul",23,2000));
		linkedList.insertNode(new Employee(3,"anna",24,-2000));
		linkedList.insertNode(new Employee(4,"peter",26,-2000));
		linkedList.insertNode(new Employee(5,"joey",25,2000));
		linkedList.sortEmployee();
		List<Employee> expectedSalaryList=new ArrayList<>();
		expectedSalaryList.add(new Employee(2,"paul",23,2000));
		expectedSalaryList.add(new Employee(5,"joey",25,2000));
		expectedSalaryList.add(new Employee(1,"john",22,-2000));
		expectedSalaryList.add(new Employee(3,"anna",24,-2000));
		expectedSalaryList.add(new Employee(4,"peter",26,-2000));
		List<Employee> actualSalaryList=linkedList.getsortedSalaryList();
		assertTrue(expectedSalaryList.equals(actualSalaryList));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
