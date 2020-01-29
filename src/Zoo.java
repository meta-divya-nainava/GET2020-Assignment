import java.util.ArrayList;
/**
  * The Class Zoo.
  */
 public class Zoo {
	
	/** The zone list. */
	private ArrayList<Zone> zoneList=new ArrayList<Zone>();
	
	/**
	 * Creates the zone.
	 *
	 * @param name the Zone name
	 * @param category the animal  category
	 * @return true, if successful
	 */
	public boolean createZone(String name,String category)
	{
		Zone object=new Zone(name,category);
		zoneList.add(object);
		return true;
	}
	
	/**
	 * Delete zone.
	 *
	 * @param zoneId the zone id
	 * @return true, if successful
	 */
	public boolean deleteZone(int zoneId)
	{
		for(int itr=0; itr<zoneList.size();itr++)
		{
			if(zoneList.get(itr).getZoneId()==zoneId)
			{
				zoneList.remove(zoneList.get(itr));
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Found zone.
	 *
	 * @param category the zone category
	 * @return the zone else null
	 */
	public Zone isZoneExist(String category)
	{
		for(int itr=0; itr<zoneList.size();itr++)
		{
			if(zoneList.get(itr).getZoneCategory().equalsIgnoreCase(category))
			{
				return zoneList.get(itr);
			}
		}
		return null;
	}
	
	/**
	 * Add the animal.
	 *@param category is animal category
	 *@param animalName is name of animal to be add
	 *@param animalWeight is weight of animal
	 *@param animalAge is age of animal
	 * @return true, if successful
	 */
	public boolean addAnimal(String categoryLocal,String animalNameLocal,int weight,int age)
	{
		InputData input=new InputData();
		String category= categoryLocal;
		String animalName=animalNameLocal;
		int animalWeight= weight;
		int animalAge= age;
		Zone ExistZone=isZoneExist(category);
		Cage ExistCage=ExistZone.isCageExist(animalName);
		if(ExistZone!=null)
		{
			if(ExistCage!=null)
			{
				Animal animalToBeAdded=null;
				if(animalName.equalsIgnoreCase("Lion"))
				{
					animalToBeAdded=new Lion(animalName,animalWeight,animalAge);
				}
				if(animalName.equalsIgnoreCase("Snake"))
				{
					animalToBeAdded=new Snake(animalName,animalWeight,animalAge);
				}
				if(animalName.equalsIgnoreCase("Piegon"))
				{
					 animalToBeAdded=new Piegon(animalName,animalWeight,animalAge);
				}
				return (ExistCage.addAnimalToCage(animalToBeAdded));
			}
			else
			{
				System.out.println("cage not found");
				System.out.println("create new Cage?\n1.Yes\n2.No");
				
				while(true)
				{
				int choice=input.getChoice();
				switch(choice)
				{
					case 1: int capacity=input.getCapacity();
							ExistZone.addCage(animalName, capacity);
							return addAnimal(category,animalName,animalWeight,animalAge);
					case 2: System.out.println("Thank you");
							return false;
					default: System.out.println("Please enter valid choice");
							break;
				
				}
				}
			}
		}
		else
		{
			System.out.println("Zone not found");
			System.out.println("create new Zone?\n1.Yes\n2.No");
			
			while(true)
			{
			int choice=input.getChoice();
			switch(choice)
			{
				case 1: String ZoneName=input.getZoneName();
						createZone(ZoneName, category);
						return addAnimal(category,animalName,animalWeight,animalAge);
				case 2: System.out.println("Thank you");
						return false;
				default:System.out.println("Please enter valid choice");
						break;
			
			}
			}
		}	
	}

	/**
	 * Death animal.
	 *
	 * @return true, if successful
	 */
	public boolean deathAnimal(String category1, String name, int id)
	{
		String category= category1;
		String animalName=name;
		int animalId=id;
		Zone ExistZone=isZoneExist(category);
		Cage ExistCage=ExistZone.isCageExist(animalName);
		if(ExistZone!=null)
		{
			if(ExistCage!=null)
			{
				ExistCage.removeFromCage(animalId);
				return true;
			}
			else
			{
				System.out.println("cage not found");
				return false;
			}
		}
		else
		{
			System.out.println("Zone not found");
			return false;
		}
		
	}
	
	/**
	 * Display zone list.
	 */
	public void displayZoneList()
	{
		System.out.println("ZoneId\t\tZoneName\tZoneCategory");
		for(int itr=0;itr<zoneList.size();itr++)
		{
			System.out.println(zoneList.get(itr).getZoneId()+"\t\t"+zoneList.get(itr).getZoneName()+"\t\t"+zoneList.get(itr).getZoneCategory());
		}
	}

}
