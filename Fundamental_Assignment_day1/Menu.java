package Fundamental_Assignment_day1;

import Fundamental_Assignment_day1.Cart;
import Fundamental_Assignment_day1.Stock;
import Fundamental_Assignment_day1.Item;
import Fundamental_Assignment_day1.Discount;

import java.util.Scanner;

public class Menu {
	public Menu()
	{
		/*
		 * welcome to dashboard class
		 * contains shopping option for user
		 */
		
		Stock stock_object=new Stock();
		Cart cart_object=new Cart();
		Discount dis_object=new Discount();
		System.out.println("Welcome to dashboard"+"\n"+"1.show stock details"
				+"\n"+"2.Add to cart"+"\n"
				+"3.Remove from cart"+"\n"+
				"4.Show total cart bill "+"\n"
				+"5.Display cart items"+"\n"
				+"6.update quantity of existing item in cart"+"\n"+
				"7.display discounted items\n"+"0 Exit");
		while(true)
		{
			System.out.println("***************");
			System.out.println("Enter your choice");
			Scanner input= new Scanner(System.in);
			int choice;
			try
			{
			choice= input.nextInt();
			switch(choice)
			{
				case 1:	stock_object.stock_details();
						break;
				case 2: cart_object.Add_to_cart();
						break;
				case 3: cart_object.remove_from_cart();
						break;
				case 4: cart_object.cart_bill();
						break;
				case 5: cart_object.Cart_deatils();
						break;
				case 6: Cart.update_quantity_of_existing_item_in_cart();
						break;
				case 7:	dis_object.discount_details();
						break;
				case 0: System.out.println("Thank you for shopping");
						return;
				default: System.out.println("Please enter valid choice");
						break;
			}
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("enter valid choice");
				
			}
		}
	}}
