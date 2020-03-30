package match;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestPriorityQueue {
	@Test
	public void testComplexMatch()
	{
		
		try {
			Bowler[] bowlers = new Bowler[3];
			bowlers[0] = new Bowler("Steyn", 6,1);
			bowlers[1] = new Bowler("Bumrah", 4,2);
			bowlers[2] = new Bowler("Starc", 8,3);
			Match match = new Match(10, bowlers);

			List<String> expectedResult = Arrays.asList("Starc", "Starc",
					"Steyn", "Starc", "Steyn","Starc","Steyn","Bumrah","Starc","Steyn");
			List<String> actualResult = match.planStrategy();

			assertTrue(expectedResult.equals(actualResult));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testSimpleMatch()
	{
		
		try {
			Bowler[] bowlers = new Bowler[3];
			bowlers[0] = new Bowler("Boult",5,1);
			bowlers[1] = new Bowler("Ferguson", 4,2);
			bowlers[2] = new Bowler("Rabada", 3,3);
			Match match = new Match(5, bowlers);

			List<String> expectedResult = Arrays.asList("Boult","Boult","Ferguson","Boult","Ferguson");
			List<String> actualResult = match.planStrategy();

			assertTrue(expectedResult.equals(actualResult));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
