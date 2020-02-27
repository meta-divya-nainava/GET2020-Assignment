
public abstract class Reptile extends Animal {
	public Reptile(String name, int age, int weight) {
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}
	/*
	 * method for get animal category
	 */
	public String getCategory()
	{
		return "Reptile";
	}
	public abstract String getSound();
	public abstract String getType();

}
