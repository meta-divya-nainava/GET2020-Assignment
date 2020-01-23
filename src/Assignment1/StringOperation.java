/*
 * @author Divya Nainava
 * @date 16-01-2020
 */
/*
/*
 * Design a class that perform following operations on Strings, without using Java APIs. Assume strings to be not null and case sensitive. 

Compare two strings and return 1 if equals else 0. Take two string inputs, compare them and return values accordingly.
Return the reverse of any string. 
Receive a string as parameter and replace lowercase characters with uppercase and vice-versa. 
Return the largest word of a string. If two words are of same length then return last word.

Also write proper specification for each method created above.

 */
package Assignment1;


public class StringOperation
{
	public static void main(String agrs[])
	{
		StringLogic logicObject=new StringLogic();
		StringInput input=new StringInput();
		String firstString;
		String secondString;
		while(true)
		{
			System.out.println("***************");
			System.out.println("1.compare strings"+"\n"+"2.reverse string"
					+"\n"+"3.replace lower case letter to upper case and vice versa."+"\n"
					+"4.Display largest word of a string"+"\n"+
					"0 Exit");
			int choice = input.getChoice();
			switch(choice)
			{
				case 1: firstString=input.getString();
						secondString=input.getString();
						System.out.println(logicObject.compareString(firstString,secondString));
						break;	
				case 2:	firstString=input.getString();
						System.out.println(logicObject.reverse(firstString));
						break;
				case 3: firstString=input.getString();
						System.out.println(logicObject.replace(firstString));
						break;
				case 4: firstString=input.getString();
						System.out.println(logicObject.largestWord(firstString));
						break;
				case 0: System.out.println("Thank you");
						return;
				default: System.out.println("Please enter valid choice");
						break;
			}
			}
	}
}
