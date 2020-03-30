package uniqueCharacter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestUniqueCharacter {
	UniqueCharacter uniquecharacter=new UniqueCharacter();
	@Test
	public void testUniqueCharacters() {
		try {
		assertEquals(2, uniquecharacter.uniqueCharacter("mmmmmmmmmn"));
		assertEquals(4, uniquecharacter.uniqueCharacter("hello"));
		assertEquals(4, uniquecharacter.uniqueCharacter("malyalam"));
		assertEquals(9,uniquecharacter.uniqueCharacter("asdfgghjkl"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testEmptyString() {
		try
		{
		assertEquals(0, uniquecharacter.uniqueCharacter(""));
		assertEquals(1, uniquecharacter.uniqueCharacter(" "));
		assertEquals(1, uniquecharacter.uniqueCharacter("  "));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testNullString() {
		try
		{
		assertEquals(0, uniquecharacter.uniqueCharacter(null));
		}
		catch (Exception e) {
			assertEquals("null input string",e.getMessage());
		}
	}
	@Test
	public void testMultipleSameString() {
		try {
		assertEquals(2, uniquecharacter.uniqueCharacter("mmmmmmmmmn"));
		assertEquals(2, uniquecharacter.uniqueCharacter("mmmmmmmmmn"));
		assertEquals(2, uniquecharacter.uniqueCharacter("mmmmmmmmmn"));
		assertEquals(2, uniquecharacter.uniqueCharacter("mmmmmmmmmn"));
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
