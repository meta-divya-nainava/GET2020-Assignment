package com.Inventory;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Inventory {
	
	private String name;
	private int quantity;
	/*
	 * method for getting name
	 * @param name is name of item.
	 */
	public String getName() {
		return name;
	}
	/*
	 * method for setting name
	 * @param name is name of item.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * method for getting quantity
	 * @param quantity is name of item.
	 */
	public int getQuantity() {
		return quantity;
	}
	/*
	 * method for getting quantity
	 * @param quantity is name of item.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "inventory [name=" + name + ", quantity=" + quantity + "]";
	}
	
}
