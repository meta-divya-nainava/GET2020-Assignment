package Assignment1;

import java.util.Scanner;

public class StringLogic {
	public int compareString(String firstString, String secondString)
	{
		/*
		 * method for comparing two strings's equality
		 * @param firstString contains value for first string.
		 * @param secondString contains value for second string
		 * @return boolean true if matches else false
		 */
		System.out.println(firstString+ secondString);
		if(firstString.length()<secondString.length() ||firstString.length()>secondString.length() )
		{
			System.out.println("if m aaya");
			return 0;
		}
		else
		{
			for(int itr=0; itr<firstString.length();itr++)
			{
				if(firstString.charAt(itr)!=secondString.charAt(itr) )
				{
					System.out.println("else if m aaya");
					return 0;
				}
			}
		}
		return 1;
		
	}
	public String reverse(String firstString)
	{
		/*
		 * method to reverse a string
		 * @param firstString contains string input
		 * @param reverseString contains reverse of firstString.
		 * @return String reverseString
		 */
		String reverseString="";
		for(int itr=(firstString.length()-1); itr>=0;itr--)
		{
			reverseString=reverseString+firstString.charAt(itr);
		}
		return reverseString;
	}
	public String replace(String firstString)
	{
		/*
		 * method to replace lower case to upper case and vice versa
		 * @param firstString contains string input
		 * @param newString contains converted string.
		 * @return String newString
		 */
		String newString="";
		for(int itr=0; itr<firstString.length();itr++)
		{
			if(firstString.charAt(itr)>='A' && firstString.charAt(itr)<='Z')
			{
				newString+=(char)((int)(firstString.charAt(itr))+32);
			}
			else if(firstString.charAt(itr)>='a' && firstString.charAt(itr)<='z')
			{
				newString+=(char)((int)(firstString.charAt(itr))-32);
			}
			else
			{
				newString+=firstString.charAt(itr);
			}
		}
		return newString;
	}
	public String largestWord(String firstString)
	{
		/*
		 * method to find largest word in string
		 * @param firstString contains string input
		 * @param maxString contains largest word.
		 * @return String maxString
		 */
		String [] words=firstString.split("\\s");
		String maxString="";
		for(int itr=0; itr<words.length; itr++)
		{
			if(words[itr].length()>=maxString.length())
			{
				maxString=words[itr];
			}
		}
		return maxString;
	}

}
