
public abstract class Bird extends Animal {
	public Bird(String name, int age, int weight) {
		super(name, age, weight);
		// TODO Auto-generated constructor stub
	}
	public abstract String getSound();
	public abstract String getType();
	/*
	 * method for get animal category
	 */
	public String getCategory()
	{
		return "Bird";
	}

}
