package Question1;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert;
public class MathTest {
	@Test
	public void testHCF() {
		try {
			Math.HCF(0,0);
		} catch (Exception e) {
			assertEquals("Input should be a positive number.", e.getMessage());
		}
	}
	@Test
	public void testHCFNegative() {
		try {
			Math.HCF(5,-1);
		} catch (Exception e) {
			assertEquals("Input should be a positive number.", e.getMessage());
		}
	}
	@Test
	public void testHCF1() throws Exception {
		assertEquals(5, Math.HCF(10,5));
	}
	@Test
	public void testHCF2() throws Exception {
		assertEquals(1000, Math.HCF(2000,1000));
	}
	@Test
	public void testHCF3() throws Exception {
		assertEquals(5, Math.HCF(0,5));
	}
	@Test
	public void testHCF4() throws Exception {
		assertEquals(5, Math.HCF(5,0));
	}
	@Test
	public void testLCM() {
		try {
			Math.LCM(0,0);
		} catch (Exception e) {
			assertEquals("Input should be a positive number", e.getMessage());
		}
	}
	@Test
	public void testLCMNegative() {
		try {
			Math.LCM(5,-1);
		} catch (Exception e) {
			assertEquals("Input should be a positive number", e.getMessage());
		}
	}
	@Test
	public void testLCMNegative1() {
		try {
			Math.LCM(0,5);
		} catch (Exception e) {
			assertEquals("Input should be a positive number", e.getMessage());
		}
	}
	@Test
	public void testLCM1() throws Exception {
		assertEquals(10, Math.LCM(10,5));
	}
	@Test
	public void testLCM2() throws Exception {
		assertEquals(20000, Math.LCM(20000,5000));
	}
}
