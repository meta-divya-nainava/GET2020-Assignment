package test;
import static org.junit.Assert.*;
import linkedlist.LinkedList;

import org.junit.Test;

/**
 * Class to test RotateSublist of LinkedList
 *
 */
public class TestRotateSublist {
	
	@Test
	public void testRotateSublist1(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(2, 5, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LinkedList expectedList = new LinkedList(new int[]{2,5,6,3,4,7});

		assertTrue(expectedList.equals(linkedList));
	}
	
	@Test
	public void testRotateSublist2(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(1, 5, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LinkedList expectedList = new LinkedList(new int[]{5,6,2,3,4,7});

		assertTrue(expectedList.equals(linkedList));
	}
	
	@Test
	public void testRotateSublist3(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(2, 6, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LinkedList expectedList = new LinkedList(new int[]{2,6,7,3,4,5});

		assertTrue(expectedList.equals(linkedList));
	}
	
	@Test
	public void TestRotateSublist4(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(1, 6, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LinkedList expectedList = new LinkedList(new int[]{5,6,7,2,3,4});

		assertTrue(expectedList.equals(linkedList));
	}
	@Test
	public void TestRotateSublist5(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(6, 5, 3);
		} catch (Exception e) {
			assertEquals("Invalid values of left and right",e.getMessage());
		}
	}
	@Test
	public void TestRotateSublist6(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(0, 5, 3);
		} catch (Exception e) {
			assertEquals("No node found at given position",e.getMessage());
		}
	}
	
	@Test
	public void TestRotateSublist7(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(2, 7, 3);
		} catch (Exception e) {
			assertEquals("No node found at given position",e.getMessage());
		}
	}
	@Test
	public void TestRotateSublist8(){
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		try {
			linkedList.rotateSubList(-2, 5, 3);
		} catch (Exception e) {
			assertEquals("No node found at given position",e.getMessage());
		}
	}
}
