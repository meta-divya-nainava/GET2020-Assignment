package Fundamental_Assignment_day1;
import Fundamental_Assignment_day1.Item;

import java.util.HashMap;
import java.util.Scanner;

public class Stock {
	/*
	 * class contains following methods for details and update in stock
	 * 1.stock details
	 * 2.get_stock
	 * 3.update_stock
	 * 4.check_item_in_stock
	 * 5.check_quantity_in_stock
	 * 6.add_item_to_stock(for admin)
	 * 7.remove_item_from_stock(for admin)
	 * 8.update_stock_price(for admin)
	 * 9.update_item_name(for admin)
	 * 10.update_stock_quantity(for admin)
	 * 
	 */
	static HashMap<Item,Integer> stock_list=new HashMap<>();
	
	public Stock()
	{
		/*
		 * constructor to initialize stock items
		 */
		stock_list.put(new Item("Mobile",20000),20);	//item_name,price,quantity
		stock_list.put(new Item("Bottle",100),20);
		stock_list.put(new Item("Laptop",25000),20);
		stock_list.put(new Item("Book",10),20);
		stock_list.put(new Item("Bag",500),20);
	}
	public void stock_details()
	{
		/*
		 * method for printing of stock items
		 */
		System.out.println("stock details:\nItem_name  Item_price  Quantity_in_stock");
		for(Item iterator_key: stock_list.keySet())
		{
			System.out.println(iterator_key.item_name+"\t\t"+iterator_key.price+"\t\t"+stock_list.get(iterator_key));
		}
	}
	public static HashMap<Item, Integer> get_stock()
	{
		return stock_list;
	}
	public static void update_stock(Item item, int quantity)
	{
		/*
		 * method for updating  quantity of item in stock after purchasing that item
		 * @param quantity represent quantity of particular item customer purchase
		 * @result updated stock
		 */
		for(Item iterator_key:stock_list.keySet())
		{
			if(iterator_key.equals(item))
			{
				int new_quantity=stock_list.get(iterator_key)-quantity;
				stock_list.replace(iterator_key, new_quantity);
			}
		}
		
	}
	
	public static boolean check_item_in_stock(String name)
	{
		/*
		 * method for checking that item name entered by user is present in stock or not
		 * @param name represents item name.
		 */
		for(Item iterator_key:stock_list.keySet())
		{
			if(name.equalsIgnoreCase(iterator_key.item_name))
			{
				return true;
			}
		}
		return false;
		
	}
	public static boolean check_quantity_in_stock(String name,int quantity)
	{
		/*
		 * method for checking that  the quantity entered by user should not be greater than total quantity in stock
		 * @param name represents item name and quantity represents quantity entered by user
		 */
		for(Item iterator_key: stock_list.keySet())
		{
			if(name.equalsIgnoreCase(iterator_key.item_name) && stock_list.get(iterator_key)>=quantity)
			{
				return true;
			}
		}
		return false;
	}
	public static void add_item_to_stock()//for admin purpose
	{
		/*
		 * method for adding items in stock
		 */
		try
		{
		Scanner input=new Scanner (System.in);
		System.out.println("enter item name");
		String local_item_name=input.next();
		System.out.println("enter item price");
		int local_price=input.nextInt();
		System.out.println("enter item quantity");
		int local_quantity=input.nextInt();
		Item item_object=new Item(local_item_name,local_price);
		stock_list.put(item_object, local_quantity);
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
			return;
		}
	}
	public static void remove_item_from_stock()//admin purpose //some issue // item that we are adding using function add_to_stock are not removing giving error .
	{
		/*
		 * method for removing items from stock
		 * @result if item present in stock then successfully remove else item not in stock message
		 */
		try
		{
		Scanner input=new Scanner (System.in);
		System.out.println("enter item_name to be remove:");
		String local_item_name=input.next();
		if(check_item_in_stock(local_item_name))
		{
			for(Item iterator_key:stock_list.keySet())
			{
				if(local_item_name.equalsIgnoreCase(iterator_key.item_name))
				{
					stock_list.remove(iterator_key);
				}
			}
			
		}
		else
		{
			System.out.println("Item not in stock");
			return;
		}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
			return;
		}
		
	}
	
	public static void update_stock_price()//for admin purpose
	{
		/*
		 * method for change in price of item that already exist in stock
		 * if not exist then will give message item not in stock
		 */
		try
		{
		System.out.println("enter item name");
		Scanner input=new Scanner (System.in);
		String name=input.next();
		if(check_item_in_stock(name))
		{
		System.out.println("enter item new price");
		int price=input.nextInt();
		for(Item iterator_key: stock_list.keySet())
		{
			if(iterator_key.item_name.equalsIgnoreCase(name))
			{
				iterator_key.set_price(price);
				stock_list.replace(iterator_key, stock_list.get(iterator_key));
			}
		}
		}
		else
		{
			System.out.println("Item not in stock");
			return;
		}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
			return;
		}
		
		
	}
	public static void update_stock_item_name()//for admin purpose
	{
		/*
		 * method for change in item_name of item that already exist in stock
		 * if not exist then will give message item not in stock
		 */
		try
		{
		System.out.println("enter old name");
		Scanner input=new Scanner (System.in);
		String old_name=input.next();
		if(check_item_in_stock(old_name))
		{
			System.out.println("enter new name");
			String new_name=input.next();
			for(Item iterator_key: stock_list.keySet())
				{
				if(iterator_key.item_name.equalsIgnoreCase(old_name))
				{
					iterator_key.set_item_name(new_name);
					stock_list.replace(iterator_key, stock_list.get(iterator_key));
				}
				}
		}
		else
		{
			System.out.println("Item not in stock");
			return;
		}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
			return;
		}
		
	}
	
	public static void update_stock_quantity()//for admin purpose
	{
		/*
		 * method for change in quantity of item that already exist in stock
		 * if not exist then will give message item not in stock
		 */
		try
		{
		System.out.println("enter item name");
		Scanner input=new Scanner (System.in);
		String name=input.next();
		if(check_item_in_stock(name))
		{
		System.out.println("enter item new quantity");
		int new_quantity=input.nextInt();
		for(Item iterator_key: stock_list.keySet())
		{
			if(iterator_key.item_name.equalsIgnoreCase(name))
			{
				stock_list.replace(iterator_key, new_quantity);
			}
		}
		}
		else
		{
			System.out.println("Item not in stock");
			return;
		}
		
	}
	catch(java.util.InputMismatchException e)
	{
		System.out.println("Invalid Input");
		return;
	}
	
}}
