package test;
import static org.junit.Assert.*;
import linkedlist.LinkedList;

import org.junit.Test;

/**
 * Class to test detectLoop method of LinkedList
 * @author Divya Nainava
 * @date 24-03-2020
 *
 */
public class TestDetectLoop {

	@Test
	public void testDetectLoop1() {
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		linkedList.createLoop(3);
		assertTrue(linkedList.detectLoop());
	}

	@Test
	public void testDetectLoop2() {
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		assertFalse(linkedList.detectLoop());
	}
	@Test
	public void testDetectLoop3() {
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		linkedList.createLoop(0);
		assertFalse(linkedList.detectLoop());
	}
	@Test
	public void testDetectLoop4() {
		LinkedList linkedList = new LinkedList(new int[]{2,3,4,5,6,7});
		linkedList.createLoop(-2);
		assertFalse(linkedList.detectLoop());
	}
}
