package linkedList;
/**
 * Class to implement a node of a linked list
 *
 */
public class Node {
	private Employee employee;
	private Node next;
	
	/**
	 * Constructor takes integer value as parameter
	 * sets value of the node initially
	 * @param value
	 */
	public Node(Employee employee){
		this.employee = employee;
		this.next = null;
	}
	
	/**
	 * Function to get the value of the node
	 * @return value
	 */
	public Employee getEmployee(){
		return this.employee;
	}
	
	/**
	 * Function to get the next node
	 * @return next node
	 */
	public Node getNext(){
		return this.next;
	} 
	
	/**
	 * Function to set next node
	 * @param next
	 */
	public void setNext(Node next){
		this.next = next;
	}
}
