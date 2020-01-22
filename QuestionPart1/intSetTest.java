package QuestionPart1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

public class intSetTest {

	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsEmpty(){
		try
		{
		intSet intSet=new intSet(new int[]{});
		}
		catch(Exception e)
		{
			assertEquals("Set Empty",e.getMessage());
		}
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetHasRepeatedElements(){
		try{
		intSet intSet=new intSet(new int[]{1,3,2,2,4});}
		catch(Exception e)
		{
			assertEquals("elements are not in range",e.getMessage());
		}
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsNotInRange(){
		try{
		intSet intSet=new intSet(new int[]{1,3,5,1111});}
		catch(Exception e)
		{
			assertEquals("repeated Elements Are Not Allowed",e.getMessage());
		}
		
	}
	@Test
	public void isMemberTest(){
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		assertEquals(true,intSet.isMember(5));
		assertEquals(false,intSet.isMember(2));
	}
	@Test
	public void isSubSetTest(){
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		assertEquals(true,intSet.isSubSet(new intSet(new int[]{8,15})));
		assertEquals(true,intSet.isSubSet(new intSet(new int[]{8,15,40})));
		assertEquals(false,intSet.isSubSet(new intSet(new int[]{9})));
	}
	@Test
	public void complimentTest(){
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		int[] expectedArray=new int[1000-intSet.size()];
		int j=0;
		for(int i=0;i<1000;i++){
			if(!(intSet.isMember(i+1))){
				expectedArray[j]=i+1;
				j++;}		
		}
		assertArrayEquals(expectedArray,(intSet.compliment()).getSetArray());
	}
}
