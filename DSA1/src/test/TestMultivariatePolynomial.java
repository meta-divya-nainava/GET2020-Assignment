package test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import polynomial.MultivariatePolynomial;

/**
 * Class to test Multivariate Polynomial findDegree method
 *
 */
public class TestMultivariatePolynomial {
	MultivariatePolynomial polynomial;

	@Test
	public void testMultivariatePolynomial1() {
		
		try {
			polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,1}, {4,1}, {3,4}, {}});
		} catch (Exception e) {
			e.printStackTrace();
		}
		int expectedDegree = 7;
		Assert.assertEquals(expectedDegree, polynomial.findDegree());
	}
	
	@Test
	public void testMultivariatePolynomial2() {
		try {
			polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,2}, {6,1}, {4,4}, {}});
		} catch (Exception e) {
			e.printStackTrace();
		}
		int expectedDegree = 8;
		Assert.assertEquals(expectedDegree, polynomial.findDegree());
	}
	@Test
	public void testMultivariatePolynomial3() {
		try {
			polynomial = new MultivariatePolynomial(new double[]{},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,2}, {6,1}, {4,4}, {}});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Null input provided",e.getMessage());
		}
	}
	@Test
	public void testMultivariatePolynomial4() {
		try {
			polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,2}, {6,1},{}});
		} catch (Exception e) {
			assertEquals("Input count mismatch",e.getMessage());
		}
	}
	@Test
	public void testMultivariatePolynomial5() {
		try {
			polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,2},{4,4},{1},{}});
		} catch (Exception e) {
			assertEquals("Null input provided",e.getMessage());
		}
	}
	@Test
	public void testMultivariatePolynomial6() {
		try {
			polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{1,2}, {6,1}, {4,4,4}, {}});
		} catch (Exception e) {
			assertEquals("Input lenght mismatch",e.getMessage());
		}
	}
	@Test
	public void testMultivariatePolynomial7() {
		try {
			polynomial = new MultivariatePolynomial(new double[]{4.6,3.5,6.0,5.4},
					new char[][]{{'x','y'}, {'x','z'},{'w','y'}, {}},
					new int[][]{{-1,-2}, {4,4},{6,1},{}});
		} catch (Exception e) {
			assertEquals("Invalid negative power found!",e.getMessage());
		}
	}
}
