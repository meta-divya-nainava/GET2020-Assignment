package Fundamental_Assignment_day1;
import java.util.Scanner;

import Fundamental_Assignment_day1.Stock;
import Fundamental_Assignment_day1.Item;

public class Admin {
	public Admin()
	{
	Scanner input= new Scanner(System.in);
	Stock stock_object=new Stock();
	while(true)
	{
		System.out.println("Welcome to dashboard of Admin"+"\n"+"1.show stock details"
				+"\n"+"2.Add to stock"+"\n"
				+"3.Remove from stock"+"\n"
				+"4.update stock item name"+"\n"
				+"5.update quantity of item in stock"+"\n"+
				"6.update price of item in stock"+"\n"+"0 Exit");
		System.out.println("Enter choice");
		int choice= input.nextInt();
		switch(choice)
		{
			case 1:	stock_object.stock_details();
					break;
			case 2: stock_object.add_item_to_stock();;
					break;
			case 3: stock_object.remove_item_from_stock();
					break;
			case 4: stock_object.update_stock_item_name();
					break;
			case 5: stock_object.update_stock_quantity();
					break;
			case 6: stock_object.update_stock_price();
					break;
			case 0: System.out.println("successfull transaction");
					return;
			default:System.out.println("Please enter valid choice");
					break;
		}
	}
	}
}

