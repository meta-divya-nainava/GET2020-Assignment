package compound;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestMolorMass {
	MolorMass molorMass=new MolorMass();	
	@Test
	public void testSimpleFormula()
	{
		try {
			assertEquals(46, molorMass.computeMass("C(OH)2"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testMediumFormula()
	{
		try {
			assertEquals(86,molorMass.computeMass("CHOC(CH3)3"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testComplexFormula()
	{
		try {
			assertEquals(115,molorMass.computeMass("CHO(OH(CH)2)2"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testInvalidFormula()
	{
		try {
			assertEquals(115,molorMass.computeMass("CHOGY"));
		} catch (Exception e) {
			assertEquals("Invalid formula", e.getMessage());
		}
	}
	@Test
	public void testNullString()
	{
		try {
			assertEquals(115, molorMass.computeMass(null));
		} catch (Exception e) {
			assertEquals("null string", e.getMessage());
		}
	}
	

}
