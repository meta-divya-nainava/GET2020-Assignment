package employee;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
	private Node head;

	/**
	 * Default constructor
	 */
	public LinkedList() {}
	
	/**
	 * Function to insert a node at end of the linked list takes integer value
	 * as parameter
	 * @param value
	 */
	public void insertNode(Employee employee) {
		Node node = new Node(employee);
		if (this.head == null) {
			this.head = node;
			return;
		}
		Node currentNode = this.head;
		while(currentNode.getNext()!=null) {
			currentNode  = currentNode.getNext();
		}
		currentNode.setNext(node);
		node.setPrev(currentNode);

	}

	/**
	 * Function to print the linked list on console
	 * @throws Exception 
	 */
	public void display() throws Exception {
		if (head == null) {
			throw new Exception("null");
		}

		for (Node currentNode = head; currentNode != null; currentNode = currentNode
				.getNext()) {
			System.out.print(currentNode.getEmployee().getEmpId()+":"+currentNode.getEmployee().getName()+":"+currentNode.getEmployee().getAge()+":"+currentNode.getEmployee().getSalary());
			if (currentNode.getNext() != null) {
				System.out.print(" -> ");
			} else {
				System.out.println();
			}
		}
	} 
	
	/**
	 * helper method to get list of Employee in descending order of salary
	 * @return List<Employee>
	 * @throws Exception 
	 */
	public List<Employee> getsortedSalaryList() throws Exception
	{
		List<Employee> salaryList=new ArrayList<>();
		if (head == null) {
			throw new Exception("null");
		}

		for (Node currentNode = head; currentNode != null; currentNode = currentNode
				.getNext()) {
			salaryList.add(currentNode.getEmployee());
		}
		return salaryList;
		
	}
	/**
	 * method for linkedlist sorting
	 * @throws Exception
	 */
	public void sort() throws Exception {
		System.out.println("in sort");
		this.quickSort(this.head, null);
	}

	/**
	 * Helper function to apply Quick Sort to the Linked List recursively
	 * @param left points to left Node
	 * @param right point to right Node
	 */
	private void quickSort(Node left, Node right) {
		System.out.println("in qucksort");
		if(left == right) {
			return;
		}
		Node pivot = left;
		Employee employee = pivot.getEmployee();
		for (Node current = left.getNext(); current != right; current = current.getNext()) {
			Employee currentEmployee = current.getEmployee();
			if (currentEmployee.getSalary() > employee.getSalary()
					|| ((currentEmployee.getSalary() .equals(employee.getSalary()))
							&& currentEmployee.getAge() < employee.getAge())) {
				System.out.println(" in if");
				current.getPrev().setNext(current.getNext());
				if(current.getNext()!=null) {
					current.getNext().setPrev(current.getPrev());
				}
				current.setPrev(pivot.getPrev());
				current.setNext(pivot);
				if(pivot.getPrev()==null) {
					this.head = current;
				} else {
					pivot.getPrev().setNext(current);
				}
				pivot.setPrev(current);
				if(left == pivot) {
					left = current;
				}
			}
		}
		quickSort(left, pivot);
		quickSort(pivot.getNext(), right);
	}

}
