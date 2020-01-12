package Fundamental_Assignment_day1;
import java.util.HashMap;

import Fundamental_Assignment_day1.Cart;
import Fundamental_Assignment_day1.Stock;
import Fundamental_Assignment_day1.Item;

public class Discount {
	/*
	 * Discount class contains following method
	 * 1.discount_details
	 * 2.discounted_price
	 * 3.discounted_bill
	 */
	static HashMap<String,Integer> discount_list=new HashMap<>();
	public Discount()
	{
		//initializing discount_list
		// admin purpose
		discount_list.put("mobile", 5);
		discount_list.put("laptop",10);
	}
	public void discount_details()
	{
		/*
		 * method for showing items that comes under discount category
		 */
		System.out.println("discount details:\nItem_name  Item_discount(%)");
		for(String iterator_key: discount_list.keySet())
		{
			System.out.println(iterator_key+"\t\t"+discount_list.get(iterator_key));
		}
	}
	public static int discounted_price(String local_item_name,int local_quantity)
	{
		/*
		 * method for calculating particular item's total price after discount
		 * @ param local_item_name represents item name and quantity represents total quantity order by user
		 * @ return original price or price after discount if available
		 */
		int total_price=0;
		int original_price=0;
		for(Item iterator_key: Stock.get_stock().keySet())
		{
			if(local_item_name.equalsIgnoreCase(iterator_key.item_name))
			{
				original_price=iterator_key.price*local_quantity;
				if(discount_list.get(iterator_key.item_name.toLowerCase())!=null)
				{
				float discount=(float)(100-discount_list.get(iterator_key.item_name.toLowerCase()))/100;
				total_price=(int) ((int)original_price*discount);//issue
				return total_price;
				}
				else
				{
					return original_price;
				}
			}
		}
		return original_price;
	}
	public int discounted_bill()
	{
		/*
		 * method for calculating total cart bill after discount
		 */
		int bill=0;
		for(Item iterator_key: Cart.item_list.keySet())
		{
			if(discount_list.get(iterator_key.item_name.toLowerCase())!=null)
				{
				float discount=(float)(100-discount_list.get(iterator_key.item_name.toLowerCase()))/100;
				bill+=(int)((int)iterator_key.price*discount);
				}
			else
			{
				bill+=iterator_key.price;
			}
		}
		return bill;
	}

}
