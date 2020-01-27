import java.util.Scanner;


public class InputData {
	Scanner in=new Scanner(System.in);
	public String getCategory()
	{
		System.out.println("Enter animal Category from following list:\nMammal\nBird\nReptile");
		String category=in.next();
		if(category.equalsIgnoreCase("bird")||category.equalsIgnoreCase("reptile")||category.equalsIgnoreCase("mammal"))
		return category;
		else
		{
			System.out.println("entered category does not match");
			return getCategory();
		}
	}
	public String getName()
	{
		System.out.println("Enter animal name or type form list:\nSnake\nLion\nPiegon");
		String name=in.next();
		if(name.equalsIgnoreCase("lion")||name.equalsIgnoreCase("snake")||name.equalsIgnoreCase("piegon"))
		return name;
		else
		{
			System.out.println("entered animal name does not match");
			return getName();
		}
	}
	public String getZoneName()
	{
		System.out.println("enter zone name:");
		return in.next();
	}
	public int getWeight()
	{
		/*
		 * method for taking choice as a input
		 * @param choice contains integer value
		 * @return integer choice
		 */
		System.out.println("Enter animal weight");
		try
		{
			int weight=in.nextInt();
			return weight;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid number");
			in.nextLine();
			return getWeight();
		}
	}
	public int getAge()
	{
		/*
		 * method for taking choice as a input
		 * @param choice contains integer value
		 * @return integer choice
		 */
		System.out.println("Enter animal Age:");
		try
		{
			int age=in.nextInt();
			return age;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid number");
			in.nextLine();
			return getAge();
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
	public int getAnimalId()
	{
		/*
		 * method for taking choice as a input
		 * @param choice contains integer value
		 * @return integer choice
		 */
		System.out.println("Enter animal Id:");
		try
		{
			int id=in.nextInt();
			return id;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid number");
			in.nextLine();
			return getAnimalId();
		}
	}
	public int getZoneId()
	{
		/*
		 * method for taking choice as a input
		 * @param choice contains integer value
		 * @return integer choice
		 */
		System.out.println("Enter Zone Id");
		try
		{
			int id=in.nextInt();
			return id;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid number");
			in.nextLine();
			return getZoneId();
		}
	}
	public int getCapacity()
	{
		/*
		 * method for taking choice as a input
		 * @param choice contains integer value
		 * @return integer choice
		 */
		System.out.println("Enter cage capacity");
		try
		{
			int capacity=in.nextInt();
			return capacity;
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Invalid number");
			in.nextLine();
			return getCapacity();
		}
	}
}
