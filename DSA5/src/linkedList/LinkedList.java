package linkedList;

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
		Node newNode = new Node(employee);
		if (head == null) {
			head = newNode;
			return;
		}
		Node last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(newNode);
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
	 * method to sort Employee list using selection sort. list is sorted according to descending order of  employee salary
	 * @throws Exception 
	 */
	public void sortEmployee() throws Exception
	{
		if (head == null) {
			throw new Exception("null");
		}
		Node preOuterNode=null;
		Node outerNode=null;
		Node preInnerNode=null;
		Node innerNode=null;
		int maxSalary=0;
		int maxAge=0;
		Node temp=null;
		
		for(outerNode=head;outerNode.getNext()!=null;outerNode=outerNode.getNext() )
		{
			maxSalary=outerNode.getEmployee().getSalary();
			maxAge=outerNode.getEmployee().getAge();
			temp=outerNode;
			preInnerNode=preOuterNode;
			for(innerNode=outerNode; innerNode.getNext()!=null; innerNode=innerNode.getNext())
			{
				if(innerNode.getNext().getEmployee().getSalary()==maxSalary)
				{
					if(innerNode.getNext().getEmployee().getAge()<maxAge)
					{
						maxAge=innerNode.getNext().getEmployee().getAge();
						maxSalary=innerNode.getNext().getEmployee().getSalary();
						preInnerNode=innerNode;
						temp=innerNode.getNext();
					}
					
				}
				else if(innerNode.getNext().getEmployee().getSalary()>maxSalary)
				{
					maxSalary=innerNode.getNext().getEmployee().getSalary();
					preInnerNode=innerNode;
					temp=innerNode.getNext();
				}
				else
				{
					continue;
				}
				
				
			}
			swap(preOuterNode,outerNode,preInnerNode,temp);	
			preOuterNode=temp;
			outerNode=temp;
			
		}
		
	}
	public void swap(Node preOuterNode,Node outerNode, Node preInnerNode,Node innerNode)
	{
		Node temp;
		if(preOuterNode!=null)
		{
			preOuterNode.setNext(innerNode);
		}
		else
		{
			this.head=innerNode;
		}
		if(preInnerNode!=null)
		{
			preInnerNode.setNext(outerNode);
		}
		else
		{
			this.head=outerNode;
		}
		temp=outerNode.getNext();
		outerNode.setNext(innerNode.getNext());
		innerNode.setNext(temp);
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
}
