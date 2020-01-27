
public abstract class Animal {
	private String animalName;
	private int animalWeight;
	private int animalAge;
	private static int counter=100;
	private int animalId;
	/*
	 * constructor for initializing Animal class variable;
	 */
	public Animal(String name, int age, int weight)
	{
		this.animalName=name;
		this.animalAge=age;
		this.animalWeight=weight;
		counter+=1;
		this.animalId=counter;
	}
	/*
	 * method for get animal name
	 */
	public String getAnimalName()
	{
		return animalName;
	}
	/*
	 * method for get animal weight
	 */
	public int getAnimalWeight()
	{
		return animalWeight;
	}
	/*
	 * method for get animal Age
	 */
	public int getAnimalAge()
	{
		return animalAge;
	}
	/*public static void updateAnimalId()
	{
		animalId-=1; }*/
	/*
	 * method for get animal Id
	 */
	public int getAnimalId()
	{
		return animalId;
	}
	public abstract String getSound();
	public abstract String getType();
	public abstract String getCategory();
}