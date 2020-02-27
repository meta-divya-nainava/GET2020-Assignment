package com.Inventory;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
	
List<Inventory> inventories;//list of items.
private static InventoryRepository container = new InventoryRepository();
	
	private InventoryRepository()
	{		
		inventories=new ArrayList<>();
		Inventory firstObject=new Inventory();
		firstObject.setName("Apples");
		firstObject.setQuantity(3);
		
		Inventory secondObject=new Inventory();
		secondObject.setName("Oranges");
		secondObject.setQuantity(7);
		
		Inventory thirdObject=new Inventory();
		thirdObject.setName("Pomergranates");
		thirdObject.setQuantity(55);
		
		inventories.add(firstObject);
		inventories.add(secondObject);
		inventories.add(thirdObject);
		
	}
	 public static InventoryRepository getInstance(){
	        return container;
	    }
	
	public List<Inventory> getInventories()
	{
		return inventories;
	}
	/*
	 * method to get details of particular item.
	 */
	public Inventory getInventory(String name)
	{
		for(Inventory itr:inventories)
		{
			if(itr.getName().compareTo(name)==0)
				return itr;
		}
		return new Inventory();
	}
	/*
	 * method to add inventory item to list.
	 */
	public void create(Inventory object)
	{
		inventories.add(object);
	}
	/*
	 * method to remove all item and then adding one item.
	 */
	public void update(Inventory object)
	{
		inventories.removeAll(inventories);
		inventories.add(object);		
	}
	/*
	 * method for updating one item.
	 */
	
	public Inventory updateOne(String name,Inventory object)
	{
		for(Inventory a:inventories)
		{
			if(a.getName().compareTo(name)==0)
			{
				a.setName(object.getName());
				a.setQuantity(object.getQuantity());
				return a;
			}
				
		}
		return new Inventory();		
	}
	/*
	 * method for deleting item.
	 */
	
	public void deleteOne(String name)
	{
		inventories.remove(getInventory(name));
	}

	public void deleteAll() 
	{
		inventories.removeAll(inventories);		
	}

}
