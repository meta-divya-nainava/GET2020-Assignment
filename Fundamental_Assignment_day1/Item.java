package Fundamental_Assignment_day1;

public class Item {
	/*
	 * class for details of item
	 */
	String item_name;
	int price;
	public Item(String name,int Local_price)
	{
		item_name=name;
		price=Local_price;
	}
	public void set_item_name(String name)//admin purpose
	{
		item_name=name;
	}
	public void set_price(int item_price)//admin purpose
	{
		price=item_price;
	}

}
