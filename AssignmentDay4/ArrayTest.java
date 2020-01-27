package AssignmentDay4;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class ArrayTest {
	@Test
	public void testCountClump() {
		try {
			ArrOperation.countClump(new int[] {});
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	@Test
	public void testCountClump1() throws Exception {
		assertEquals(2, ArrOperation.countClump(new int[] { 1, 2, 2, 3, 4, 4 }));
	}

	@Test
	public void testNumberOfClumps2() throws Exception {
		assertEquals(2, ArrOperation.countClump(new int[] { 1, 1, 2, 1, 1 }));
	}

	@Test
	public void testNumberOfClumps3() throws Exception {
		assertEquals(1, ArrOperation.countClump(new int[] { 1, 1, 1, 1, 1 }));
	}
	@Test
	public void testNumberOfClumps4() throws Exception {
		assertEquals(0, ArrOperation.countClump(new int[] { 1 }));
	}
	@Test
	public void testNumberOfClumps5() throws Exception {
		assertEquals(1, ArrOperation.countClump(new int[] { -1,-1 }));
	}

	@Test
	public void testsplitArray() {
		try {
			ArrOperation.splitArray(new int[] {});
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}
	@Test
	public void testSplitArray1() throws Exception{  
	assertEquals(3,ArrOperation.splitArray(new int[]{ 1, 1, 1, 2, 1}));
	}

	@Test
	public void testSplitArray2() throws Exception{  
	assertEquals(-1,ArrOperation.splitArray(new int[]{2, 1, 1, 2, 1}));
	}

	@Test
	public void testSplitArray3() throws Exception{  
	assertEquals(1,ArrOperation.splitArray(new int[]{10,10}));
	}
	@Test
	public void testSplitArray4() throws Exception{  
	assertEquals(-1,ArrOperation.splitArray(new int[]{0}));
	}
	@Test
	public void testSplitArray5() throws Exception{  
	assertEquals(-1,ArrOperation.splitArray(new int[]{3,-1,-1,1}));
	}
	
	@Test
	public void testFixXYArray() {
	try {
	ArrOperation.fixXY(new int[]{ },4,5);
	}
	catch (Exception e) {
	assertEquals("Array is empty.", e.getMessage());
	}
	}

	@Test
	public void testfixXYUnequal() {
	try {
	ArrOperation.fixXY(new int[]{4,5,2,4,2},4,5);
	}
	catch (Exception e) {
	assertEquals("x and y are unequal", e.getMessage());
	}
	}
	@Test
	public void testfixXYAdjacent() {
	try {
	ArrOperation.fixXY(new int[]{4,4,5,5,3,1 },4,5);
	}
	catch (Exception e) {
	assertEquals("Two adjacents X values are there", e.getMessage());
	}
	}
	@Test
	public void testfixXYLastX() {
	try {
	ArrOperation.fixXY(new int[]{4,3,5,4,3,2,5,5,4},4,5);
	}
	catch (Exception e) {
	assertEquals("X is at last position", e.getMessage());
	}
	}
	@Test
	public void testfixXY1() throws Exception{
	int returnedArr[] = ArrOperation.fixXY(new int[]{5, 4, 9, 4, 9, 5},4,5);
	int []expectedArr = new int[]{9, 4, 5, 4, 5, 9};
	Assert.assertArrayEquals(expectedArr, returnedArr );
	}
	@Test
	public void testfixXY2() throws Exception{
	int returnedArr[] = ArrOperation.fixXY(new int[]{1,4,1,5},4,5);
	int []expectedArr = new int[]{1,4,5,1};
	Assert.assertArrayEquals( expectedArr, returnedArr );
	}
	@Test
	public void testfixXY3() throws Exception{
	int returnedArr[] = ArrOperation.fixXY(new int[]{1,4,1,5,5,4,1},4,5);
	int []expectedArr = new int[]{1,4,5,1,1,4,5};
	Assert.assertArrayEquals( expectedArr, returnedArr );
	}
	@Test
	public void testfixXY4() throws Exception{
	int returnedArr[] = ArrOperation.fixXY(new int[]{0},4,5);
	int []expectedArr = new int[]{0};
	Assert.assertArrayEquals( expectedArr, returnedArr );
	}
	@Test
	public void testfixXY5() throws Exception{
	int returnedArr[] = ArrOperation.fixXY(new int[]{-2,6,2,-3,4,5,8,7,-2,-3},-2,-3);
	int []expectedArr = new int[]{-2,-3,2,6,4,5,8,7,-2,-3};
	Assert.assertArrayEquals( expectedArr, returnedArr );
	}
	@Test
	public void testLargestMirrorSection() {
	try {
	ArrOperation.largestMirrorSection(new int[]{ });
	}
	catch (Exception e) {
	assertEquals("Array is empty.", e.getMessage());
	}
	}
	@Test
	public void testLargestMirrorSection1() throws Exception {  
	assertEquals(3,ArrOperation.largestMirrorSection(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
	}
	@Test
	public void testLargestMirrorSection2() throws Exception{  
	assertEquals(2,ArrOperation.largestMirrorSection(new int[]{7,1,4,9,7,4,1}));
	}
	@Test
	public void testLargestMirrorSection3() throws Exception{  
	   assertEquals(3,ArrOperation.largestMirrorSection(new int[]{1, 2, 1,4}));
	}
	@Test
	public void testLargestMirrorSection4() throws Exception{  
	assertEquals(7,ArrOperation.largestMirrorSection(new int[]{1, 4, 5, 3, 5, 4, 1}));
	}
	@Test
	public void testLargestMirrorSection5() throws Exception{  
	assertEquals(0,ArrOperation.largestMirrorSection(new int[]{1,2,3,4,5}));
	}
	@Test
	public void testLargestMirrorSection6() throws Exception{  
	assertEquals(2,ArrOperation.largestMirrorSection(new int[]{1,1}));
	}

} 

