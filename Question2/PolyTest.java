package Question2;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class PolyTest {
	//PolyObject object;
	polyArray Object;
	@Test
	public void validateDegree() {
		try {
			Object.addPoly(new PolyObject(1,-1));
		} catch (Exception e) {
			assertEquals("Enter degree greater than 0", e.getMessage());
		}
	}

}
