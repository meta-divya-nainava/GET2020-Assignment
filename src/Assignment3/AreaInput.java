package Assignment3;

import java.util.Scanner;

public class AreaInput {
	Scanner input=new Scanner(System.in);
	public double getWidth()
	{
		/*
		 * method for taking width as a input
		 * @param width contains width
		 * @return float width
		 */
		try
		{
		System.out.println("Enter width");
		double width=input.nextDouble();
		return width;
		}
		catch(Exception e)
		{
			System.out.println("please enter valid width");
			input.nextLine();
			return getWidth();
		}
	}
	public double getHeight()
	{
		/*
		 * method for taking height as a input
		 * @param height contains height
		 * @return float height
		 */
		try{
		System.out.println("Enter height");
		double height=input.nextDouble();
		return height;
		}
		catch (Exception e)
		{
			System.out.println("please enter valid height");
			input.nextLine();
			return getHeight();
		}
	}
	public double getRadius()
	{
		/*
		 * method for taking radius as a input
		 * @param radius contains radius
		 * @return float radius
		 */
		try
		{
		System.out.println("Enter Radius");
		double radius=input.nextDouble();
		return radius;
		}
		catch(Exception e)
		{
			System.out.println("please enter valid radius");
			input.nextLine();
			return getRadius();
		}
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
			return getChoice();//issue
		}
	}

}
