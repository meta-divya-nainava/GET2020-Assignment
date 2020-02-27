import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
public class ZooTest {
	Zoo object=new Zoo();
	@Test
	public void addZoneTest()
	{
		assertEquals(true,object.createZone("Zone1", "Mammal"));
	}
	@Test
	public void addCageTest()
	{
		assertEquals(true,new Zone("Zone1","Mammal").addCage("Lion", 2));
	}
	@Test
	public void addAnimalTest()
	{
		assertEquals(true,object.addAnimal("Mammal","Lion",45,78));
	}
	@Test
	public void deathAnimalTest()
	{
		assertEquals(false,object.deathAnimal("Mammal","Lion",101));
	}


}
