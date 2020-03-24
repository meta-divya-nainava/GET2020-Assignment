package linkedlist;

public class LinkedList {
	private Node head;

	/**
	 * Default constructor
	 */
	public LinkedList() { }
	
	/**
	 * Constructor that makes linked list from an array
	 * @param items an array of integers
	 */
	public LinkedList(int[] items){
		if(items == null){
			return;
		}
		for(int item: items){
			this.insertNode(item);
		}
	}
	
	/**
	 * Function to insert a node at end of the linked list takes integer value
	 * as parameter
	 * @param value
	 */
	public void insertNode(int value) {
		Node newNode = new Node(value);
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
	 */
	public void display() {
		if (head == null) {
			System.out.println("null");
			return;
		}

		for (Node currentNode = head; currentNode != null; currentNode = currentNode
				.getNext()) {
			System.out.print(currentNode.getValue());
			if (currentNode.getNext() != null) {
				System.out.print(" -> ");
			} else {
				System.out.println();
			}
		}
	}
	/**
	 * Function to rotate sublist in clockwise direction by given number of
	 * steps
	 * 
	 * @param leftPosition
	 *            a positive value in range of size of the linked list
	 * @param rightPosition
	 *            a positive value in range of size of the linked list and not
	 *            less than leftPosition
	 * @param steps
	 *            a not-negative integer
	 * @return true if rotated successfully or false otherwise
	 * @throws Exception 
	 */
	public boolean rotateSubList(int leftPosition, int rightPosition, int steps) throws Exception {
		if (leftPosition > rightPosition) {
			throw new Exception("Invalid values of left and right");
		}
		Node leftNode = this.head;
		Node prevOfLeftNode = null;
		
		//node at position leftPosition is assigned to leftNode.
		for (int i = 1; i <= leftPosition; i++) {
			if (leftNode == null) {
				throw new Exception("No node found at given position");
			}
			if (i < leftPosition) {
				prevOfLeftNode = leftNode;
				leftNode = leftNode.getNext();
			}
		}

		Node rightNode = leftNode;
		//node at position rightPosition is assigned to rightNode.
		for (int i = leftPosition; i <= rightPosition; i++) {
			if (rightNode == null) {
			}
			if (i < rightPosition) {
				rightNode = rightNode.getNext();
			}
		}

		int subListLength = rightPosition - leftPosition + 1;
		steps %= subListLength;
		
		if(steps == 0){
			return true;
		}
		
		Node breakNode = leftNode;
		for (int i = 1; i < steps; i++) {
			breakNode = breakNode.getNext();
		}
		if(prevOfLeftNode != null){
			prevOfLeftNode.setNext(breakNode.getNext());
		} else {
			this.head = breakNode.getNext();
		}
		breakNode.setNext(rightNode.getNext());
		rightNode.setNext(leftNode);
		return true;
	}
	/**
	 * Function that connects last node to given position
	 * 
	 * @param position
	 *            a positive value in range of size of the linked list
	 */
	public void createLoop(int position) {
		if (this.head == null) {
			return;
		}
		Node currentNode = null, lastNode = this.head;
		for (int i = 0;; i++, lastNode = lastNode.getNext()) {
			if (i + 1 == position) {
				currentNode = lastNode;
			}
			if (lastNode.getNext() == null) {
				break;
			}
		}
		if (currentNode == null) {
			return;
		}
		lastNode.setNext(currentNode);
	}
	
	/**
	 * Function to detect loop in the linked list if present
	 * @param slowIterator iterate over one node
	 * @param fastIterator iterate over two node
	 * @return true if loop is present or false otherwise
	 */
	public boolean detectLoop() {
		if (this.head == null) {
			return false;
		}
		Node slowIterator = this.head;
		Node fastIterator = this.head.getNext();
		while (fastIterator != null) {
			if (slowIterator == fastIterator) {
				return true;
			}
			slowIterator = slowIterator.getNext();
			fastIterator = fastIterator.getNext();
			if (fastIterator == null) {
				break;
			}
			fastIterator = fastIterator.getNext();
		}
		return false;
	}
	
	/**
	 * Checks if two linked list are equal
	 * 
	 * @param linkedList
	 * @return true if equal or false otherwise
	 */
	public boolean equals(LinkedList linkedList) {
		if (linkedList == null) {
			return false;
		}
		Node currentNode1 = this.head;
		Node currentNode2 = linkedList.head;
		while (currentNode1 != null && currentNode2 != null) {
			if (currentNode1.getValue() != currentNode2.getValue()) {
				return false;
			}
			currentNode1 = currentNode1.getNext();
			currentNode2 = currentNode2.getNext();
		}
		return currentNode1 == currentNode2;
	}

}
