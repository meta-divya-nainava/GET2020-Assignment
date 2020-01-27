
public abstract class Mammal extends Animal{
	public Mammal(String name, int age, int weight) {
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}
	/*
	 * method for get animal category
	 */
	public String getCategory()
	{
		return "Mammal";
	}
	public abstract String getSound();
	public abstract String getType();
	
	
	

}
