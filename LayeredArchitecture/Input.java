package LayeredArchitecture;

import java.util.Scanner;
/**
 * The Class Input.
 */
public class Input {
	
	/** The in. */
	Scanner in=new Scanner(System.in);
	
	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int getProductId()
	{
		try{
		System.out.println("Enter product Id:");
		int id=in.nextInt();
		return id;}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid Id please enter valid Id");
			in.nextLine();
			return getProductId();
		}
	}
	
	/**
	 * Gets the product quantity.
	 *
	 * @return the product qty
	 */
	public int getProductQty()
	{
		try{
		System.out.println("enter quantity");
		int qty=in.nextInt();
		if(qty<0)
		{
			throw new ArithmeticException();
		}
		return qty;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid quantity");
			in.nextLine();
			return getProductQty();
		} catch (ArithmeticException e) {
			System.out.println("Quantity should be grater than 0");
			in.nextLine();
			return getProductQty();
		}
	}
	
	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public int getProductPrice()
	{
		int price=in.nextInt();
		return price;
	}
	
	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	public String getProductType()
	{
		System.out.println("enter product type");
		String name=in.next();
		return name;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail()
	{
		try
		{
		System.out.println("Enter your email");
		String email=in.next();
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(email.matches(regex))
		{
			return email;
		}
		else
		{
			throw new Exception();
		}
		
		}
		catch(Exception e)
		{
			System.out.println("enter valid email address");
			in.nextLine();
			return getEmail();
		}
		
	}
	
	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName()
	{
		String name=in.next();
		return name;
	}
	
	/**
	 * Gets the choice.
	 *
	 * @return the choice
	 */
	public int getChoice()
	{
		System.out.println("Enter your choice from menu");
		try
		{
			int choice=in.nextInt();
			return choice;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid number please enter another choice");
			in.nextLine();
			return getChoice();
		}
	}

}
