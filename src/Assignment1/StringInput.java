package Assignment1;

import java.util.Scanner;

public class StringInput {
	Scanner input=new Scanner(System.in);
	public String getString()
	{
		/*
		 * method for taking string as a input
		 * @param input for scanner class
		 * @param firsString contains input string
		 * @return firstString
		 */
		System.out.println("Enter String:");
		return input.next();
	}
	public int getChoice()
	{
		/*
		 * method for taking choice as a input
		 * @param choice contains integer value
		 * @return integer choice
		 */
		System.out.println("Enter your choice from menu");
		try
		{
			int choice=input.nextInt();
			return choice;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid choice please enter another choice");
			input.nextLine();
			return getChoice();
		}
	}

}
