import java.util.ArrayList;

public class Cage {
	private int totalCapacity;
	private int cageCount = 0;
	private String typeOfCage;
	private int noOfAnimal;
	private int cageId;
	
	
	private static ArrayList<Animal> AnimalList = new ArrayList<Animal>();
	
	public Cage(String cageType, int capacity) {
		cageCount++;
		this.totalCapacity = capacity;
		this.typeOfCage = cageType;
		this.noOfAnimal=0;
		this.cageId=cageCount;
	}
	/*
	 * method for checking if cage has capacity or not to keep an animal
	 * @param totalCapacity is total capacity of cage
	 * @param noOfAnimal is total number of animal in cage
	 * @return true if cage is full else false
	 */
	private boolean isCageFull()
	{
		if(totalCapacity==noOfAnimal)
		{
			return true;
		}
		return false;
	}
	/*
	 * method for adding animal to cage
	 * @param animalTOBeAdd is object of Animal class
	 * @return true if animal is added else false
	 */
	public boolean addAnimalToCage(Animal animalToBeAdd)
	{
		if(!(isCageFull())&& typeOfCage.equalsIgnoreCase(animalToBeAdd.getType()))
		{
			AnimalList.add(animalToBeAdd);
			noOfAnimal++;
			return true;
		}
		else
		{
			System.out.println("Can not be added -out of capacity");
			return false;
		}
	}
	/*
	 * method for display list of animal in cage
	 */
	public static void displayAnimalList()
	{
		System.out.println("AnimalId\tAnimalName\tAnimalWight\tAnimalAge");
		for(int itr=0;itr<AnimalList.size();itr++)
		{
			System.out.println(AnimalList.get(itr).getAnimalId()+"\t\t"+AnimalList.get(itr).getAnimalName()+"\t\t"+AnimalList.get(itr).getAnimalWeight()+"\t\t"+AnimalList.get(itr).getAnimalAge());
		}
	}
	/*
	 * method for removing animal to cage
	 * @param animalId id id of animal that is to be removed
	 * @return true if animal is removed else false
	 */
	public boolean removeFromCage(int animalId)
	{
		for(int itr=0; itr<AnimalList.size();itr++)
		{
			if(AnimalList.get(itr).getAnimalId()==animalId)
			{
				AnimalList.remove(AnimalList.get(itr));
				return true;
			}
		}
		return false;
	}
	public String getCageType()
	{
		return typeOfCage;
	}
	public int getNoOfAnimal()
	{
		return noOfAnimal;
	}
	public int getTotalCapacity()
	{
		return totalCapacity;
	}
	public int getCageId()
	{
		return cageId;
	}
	public ArrayList<Animal>getCageList()
	{
		return AnimalList;
	}
}
