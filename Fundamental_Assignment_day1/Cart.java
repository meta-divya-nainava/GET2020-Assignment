package Fundamental_Assignment_day1;

import Fundamental_Assignment_day1.Item;
import Fundamental_Assignment_day1.Stock;
import Fundamental_Assignment_day1.Discount;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cart {
	/*
	 * cart class contains following methods
	 * 1 Add to cart
	 * 2 remove from cart
	 * 3 cart details
	 * 4 cart bill
	 * 5 check item in cart
	 * 6 update quantity of existing item in cart
	 * 7 calculate price(method for calculating total price of individual item)
	 */
	static HashMap<Item,Integer> item_list=new HashMap<>();
	public void Add_to_cart()
	{
		/*add to cart if item is present in stock
		 * @param total_price of particular item
		 * @ result if item is present then it will be added to cart else message item not present
		 * 			if quantity order by user is not present in stock then message out of stock
		 */
		System.out.println("enter item_name:");
		Scanner input= new Scanner(System.in);
		try
		{
		String local_item_name=input.next();
		if(Stock.check_item_in_stock(local_item_name))
		{
			System.out.println("enter item_quantity:");
			int local_quantity=input.nextInt();
			if(Stock.check_quantity_in_stock(local_item_name, local_quantity))
			{
				int total_price=Calculate_price(local_item_name,local_quantity);
				Item new_cart_item= new Item(local_item_name,total_price);
				item_list.put(new_cart_item, local_quantity);
				Stock.update_stock(local_item_name, local_quantity);
				
			}
			else
			{
				System.out.println("Out of stock");
				return;
			}
		}
		else
		{
			System.out.println("Item is not in stock");
			return;
		}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
			return;
		}
		}
	public void remove_from_cart()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("enter item to be remove");
		try{
		String local_item_name=input.next();
		if(check_item_in_cart(local_item_name))
		{
			for(Item iterator_key: item_list.keySet())
			{
				if(local_item_name.equalsIgnoreCase(iterator_key.item_name))
				{
					item_list.remove(iterator_key);
				}
			}
			
		}
		else
		{
			System.out.println("Item is not in cart");
			return;
		}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
		}
		
	}
	public boolean check_item_in_cart(String local_item_name)
	{
		for(Item iterator_key: item_list.keySet())
		{
			if(local_item_name.equalsIgnoreCase(iterator_key.item_name))
			{
				return true;
			}
		}
		return false;
		
	}
	public void Cart_deatils()
	{
		/*
		 * method for showing cart details
		 */
		Discount dis_object=new Discount();
		System.out.println("item_name  item_price  discounted_price  item_quantity");
		for(Item iterator_key: item_list.keySet())
		{
			System.out.println(iterator_key.item_name+"\t\t"+ iterator_key.price+"\t\t"+ dis_object.discounted_price(iterator_key.item_name,item_list.get(iterator_key))+"\t\t" +item_list.get(iterator_key) );
		}
	}
	public void cart_bill()
	{
		/*
		 * method for calculating total cart bill
		 */
		Discount dis_object=new Discount();
		int bill=0;
		for(Item iterator_key: item_list.keySet())
		{
			bill+=iterator_key.price;
		}
		System.out.println("originial_bill="+bill+"\n"+"After_discount_bill="+dis_object.discounted_bill());
	}
	public static  void update_quantity_of_existing_item_in_cart()
	{
		/*
		 * method for updating quantity of existing item in cart
		 */
		System.out.println("Enter 1 to add in Quantity\n Enter 2 to subtract in Quantity");
		Scanner input=new Scanner (System.in);
		try{
		int choice=input.nextInt();
		System.out.println("Enter item_name");
		String item_name=input.next();
		switch(choice)
		{
		case 1:	System.out.println("how much quantity you want to add? :");
				int quantity=input.nextInt();	
				add_quantity_in_existing_item(item_name,quantity);
				break;
		case 2: System.out.println("how much quantity you want to subtract? :");
				int quantity_=input.nextInt(); 
				subtract_quantity_in_existing_item(item_name,quantity_);
				break;
		default: System.out.println("Enter valid choice");
				return;
			
		}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Input");
			return;
		}
	}
	public static  void add_quantity_in_existing_item(String name,int quantity)
	{
		/*
		 * this method is used in update_quantity_of_existing_item_in_cart
		 */
		for(Item iterator_key: item_list.keySet())
		{
			if(iterator_key.item_name.equalsIgnoreCase(name) )
			{
				int new_quantity=item_list.get(iterator_key)+quantity;
				item_list.replace(iterator_key, new_quantity);
				iterator_key.price=Calculate_price(name,new_quantity);
				Stock.update_stock(name ,quantity);
			}
		}
		
	}
	public static void subtract_quantity_in_existing_item(String name,int quantity)
	{
		/*
		 * this method is used in update_quantity_of_existing_item_in_cart
		 */
		for(Item iterator_key: item_list.keySet())
		{
			if(iterator_key.item_name.equalsIgnoreCase(name))
			{
				int new_quantity=item_list.get(iterator_key)-quantity;
				item_list.replace(iterator_key, new_quantity);
				iterator_key.price=Calculate_price(name,new_quantity);
				Stock.update_stock(name ,-quantity);
			}
		}
		
	}
	public static int Calculate_price(String local_item_name,int local_quantity)
	{
		/*
		 * method for calculating particular item's total price
		 * @ param local_item_name represents item name and quantity represents total quantity order by user
		 * 
		 */
		int total_price=0;
		for(Item iterator_key: Stock.get_stock().keySet())
		{
			if(local_item_name.equalsIgnoreCase(iterator_key.item_name))
			{
				total_price=iterator_key.price*local_quantity;
				return total_price;
			}
		}
		return 0;
	}

}
