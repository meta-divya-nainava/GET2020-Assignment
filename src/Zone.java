import java.util.ArrayList;


public class Zone {
	private String zoneName;
	private static int counter=0;
	private int zoneId;
	private String zoneCategory;
	private static  ArrayList<Cage> cageList=new ArrayList<Cage>();
	public Zone(String name, String category)
	{
		this.zoneName=name;
		this.zoneCategory=category;
		counter+=1;
		this.zoneId=counter;
	}
	/*
	 * method for adding cage to zone
	 * @param Capacity is total capacity of cage
	 * @param cageType is type of cage
	 * @return true if cage is added
	 */
	public boolean addCage(String cageType,int capacity)
	{
		Cage object=new Cage(cageType,capacity);
		cageList.add(object);
		return true;
	}
	/*
	 * method for removing cage to zone
	 * @param cageId is id of cage to be remove
	 * @param cageType is type of cage
	 * @return true if cage is added
	 */
	public boolean removeCage(int cageId)
	{
		for(int itr=0; itr<cageList.size();itr++)
		{
			if(cageList.get(itr).getCageId()==cageId)
			{
				cageList.remove(cageList.get(itr));
				return true;
			}
		}
		return false;
	}
	/*
	 * method for checking if a particular cage type exist or not
	 * @param cagetype type of cage
	 * @return cage object if found else none
	 */
	public Cage checkCage(String cageType)
	{
		for(int itr=0; itr<cageList.size();itr++)
		{
			if(cageList.get(itr).getCageType().equalsIgnoreCase(cageType))
			{
				return cageList.get(itr);
			}
		}
		return null;
	}
	/*
	 * method for displaying cage list
	 */
	public static void displayCageList()
	{
			System.out.println("CageId\t\tCageType\tCageTotalCapacity");
			for(int itr=0;itr<cageList.size();itr++)
			{
				System.out.println(cageList.get(itr).getCageId()+"\t\t"+cageList.get(itr).getCageType()+"\t\t"+cageList.get(itr).getTotalCapacity());
			}
	}
	public String getZoneName()
	{
		return zoneName;
	}
	public int getZoneId()
	{
		return zoneId;
	}
	public String getZoneCategory()
	{
		return zoneCategory;
	}
	public ArrayList<Cage> getCageList()
	{
		return cageList;
	}
}
