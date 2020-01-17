package Assignment2;

import java.util.Scanner;

public class GradeInput {
	Scanner input=new Scanner(System.in);
	public int getSize()
	{
		/*
		 * method for taking array size
		 * @param size contains size of array
		 * @return integer size
		 */
		int size;
		try
		{
		System.out.println("Enter total number of students");
		size= input.nextInt();
		if(size<=0)
		{
			throw new ArithmeticException();
		}
		return size;
		}
		catch(ArithmeticException e)
		{
			System.out.println("please enter number greater than zero");
			input.nextLine();
			return getSize();
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			input.nextLine();
			return getSize();
		}
		
	}
	public float [] getGrade(int size,int n)
	{
		/*
		 * method for taking array elements
		 * @param size contains size of array
		 * @param arr array contains element 
		 * @return float arr
		 */
		int itr=n;
		try
		{
		float[] arr=new float[size];
		for(itr=n; itr<size; itr++)
		{
			System.out.println("Enter grade for student "+(itr+1));
			arr[itr]=input.nextFloat();
			// issue
		}
		return arr;
		
		}
		catch(Exception e)
		{
			System.out.println("please enter valid element in array");
			input.nextLine();
			return getGrade(size,itr);
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
