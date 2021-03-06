package AssignmentDay4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ArrParameterizeTest {
	private int[] array;
	private int exp;

	public ArrParameterizeTest(int[] array, int ex) {
		this.array = array;
		this.exp = ex;
	}

	@Parameters
	public static Collection<Object[]> method1() {
		Object[][] data = new Object[][] {
				{ new int[] { 1, 2, 2, 3, 4, 4 }, 2 },
				{ new int[] { 1, 1, 2, 1, 1 }, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1 }, { new int[] {}, 0 }

		};
		return Arrays.asList(data);
	}

	@Test
	public void testCountClumps() {
		try {
			assertEquals(exp, ArrOperation.countClump(array));
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
			}
		}
	}

