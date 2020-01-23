/*
 * @author: Divya nainava
 * @date: 14-01-2020
 */
/* Question 1

Design a class HexCalc that supports following methods for hexadecimal arithmetic. You can assume that this class will be working with only positive integers.

Methods to add, subtract, multiply and divide two hexadecimal numbers. Each of the methods will receive hexadecimal numbers as strings, and will return the computed value as hexadecimal string. The strategy that can be followed by each of the methods is to convert the strings into numbers, perform the computation, and reconvert the result back into hexadecimal representation.
Methods to compare two hexadecimal numbers for ==, > and <. Each of these methods will return a boolean value. Implement these methods without converting the arguments to decimal numbers for comparison.
Return the decimal representation of hexadecimal number.
Return the hexadecimal representation of decimal number.

How would you generalise this to support arithmetic in any base?

 */
package Fundamental_Assignment_day2;

import java.util.*;
import java.lang.Math;
import java.lang.String;

class Hex
{
	/*
	 * class Hex contains following method
	 * 1. convert_number_to_hexadecimal_number
	 * 2. convert_number_to_decimal
	 * 3. Add
	 * 4. Subtract
	 * 5. Multiplication
	 * 6. Divide
	 * 7. Compare
	 */
	HashMap<Character,Integer>char_list=new HashMap<>();
	public Hex()
	{
		char_list.put('A',10);
		char_list.put('B',11);
		char_list.put('C',12);
		char_list.put('D',13);
		char_list.put('E',14);
		char_list.put('F',15);
		
	}
	public float ToDecimal(String number,int base)
	{
		/*
		 * method to convert hexadecimal number to decimal number
		 * @param words string array contains string before decimal point and after decimal point
		 * @param itr for iterate over string
		 * @return float decimal number
		 */
		float NumberBeforeDecimalPoint=0;
		float NumberAfterDecimalPoint=0;
		String [] words =number.split("\\.");//to split string number before and after decimal point
		int LengthOfWord=(words[0].length())-1;
		for(int itr=0;itr<words[0].length();itr++)
		{
			if(char_list.get(words[0].charAt(itr))!=null)
			{
				NumberBeforeDecimalPoint+=(char_list.get(words[0].charAt(itr))*Math.pow(base,LengthOfWord));
				LengthOfWord--;
			}
			else
			{
				NumberBeforeDecimalPoint+=((words[0].charAt(itr)-'0')*Math.pow(base,LengthOfWord));
				LengthOfWord--;
			}
		}
		if(words.length==2)
		{
			for(int itr=0;itr<words[1].length();itr++)
			{
				if(char_list.get(words[1].charAt(itr))!=null)
				{
					NumberAfterDecimalPoint+=(char_list.get(words[1].charAt(itr))*(1/Math.pow(base,(itr+1))));
				}
				else
				{
					NumberAfterDecimalPoint+=((words[1].charAt(itr)-'0')*(1/Math.pow(base,(itr+1))));
				}
			}
			
		}
		
		return (NumberBeforeDecimalPoint+NumberAfterDecimalPoint);
		
		
	}
	public char FindKey(int value)
	{
		/*
		 * method for finding key in hashmap char_list
		 */
		for(char itr: char_list.keySet())
		{
			if(char_list.get(itr)==value)
			{
				return itr;
			}
			
		}
		return '\0';
	}
	public String ToHexadecimalNumber(float DecimalNumber,int base)
	{
		/*
		 * method to convert decimal number to hexadecimal number
		 * @param result contains converted hexadecimal string
		 * @param result reverse contains reverse string of result
		 * @param result_decimal contains hexadecimal string after decimal point
		 * @param n value used for loop 
		 * @return string hexadecimal number
		 */
		int BeforeDecimal=(int)DecimalNumber;
		float AfterDecimal=(DecimalNumber-(float)BeforeDecimal);
		String result="";
		String ResultDecimal="";
		String ResultReverse="";
		if(BeforeDecimal==0)
		{
			result="0";
		}
		while(BeforeDecimal!=0)
		{
			int remainder= BeforeDecimal%base;
			if(FindKey(remainder)!='\0')
			{
				result=result+FindKey(remainder);
			}
			else
			{
				result=result+remainder;
			}
			BeforeDecimal=(int)(BeforeDecimal/base);
		}
		int n=0;
		while(n!=2)
		{
			AfterDecimal=AfterDecimal*base;
			int IntegerPart=(int)AfterDecimal;
			if(FindKey(IntegerPart)!='\0')
			{
				ResultDecimal=ResultDecimal+FindKey(IntegerPart);
			}
			else
			{
				ResultDecimal=ResultDecimal+IntegerPart;
			}
			AfterDecimal=(AfterDecimal-(float)IntegerPart);
			n++;
		}
		StringBuilder HexOutput= new StringBuilder();
		HexOutput.append(result);
		result=HexOutput.reverse().toString();
		if(!(ResultDecimal.isEmpty()))
		{
			result=result+"."+ResultDecimal;
		}
		
		return result;
		
	}
	public String Add(String first_number,String second_number)
	{
		/*
		 * method for adding two hexadecimal numbers
		 * @param decimal_first contains integer part of decimal value
		 * @param decimal_second contains fraction part of decimal value
		 * @param result added value of decimal numbers
		 * @param result_string contains resulting hexadecimal value in string
		 * @return result_string
		 */
		float DecimalFirst= ToDecimal(first_number,16);
		float DecimalSecond= ToDecimal(second_number,16);
		float result= DecimalFirst+DecimalSecond;
		String ResultString=ToHexadecimalNumber(result,16);
		return ResultString;
	}
	public String Subtract(String first_number,String second_number)
	{

		/*
		 * method for subtracting two hexadecimal numbers
		 * @param decimal_first contains integer part of decimal value
		 * @param decimal_second contains fraction part of decimal value
		 * @param result subtracted value of decimal numbers
		 * @param result_string contains resulting hexadecimal value in string
		 * @return result_string
		 */
		float DecimalFirst= ToDecimal(first_number,16);
		float DecimalSecond= ToDecimal(second_number,16);
		float result;
		if(DecimalFirst>DecimalSecond)
		{
			result= DecimalFirst-DecimalSecond;
		}
		else
		{
			result=DecimalSecond-DecimalFirst;
		}
		
		String ResultString=ToHexadecimalNumber(result,16);
		return ResultString;
	}
	public String Multiplication(String first_number,String second_number)
	{

		/*
		 * method for multiplication of  two hexadecimal numbers
		 * @param decimal_first contains integer part of decimal value
		 * @param decimal_second contains fraction part of decimal value
		 * @param result multiplied value of decimal numbers
		 * @param result_string contains resulting hexadecimal value in string
		 * @return result_string
		 */
		float DecimalFirst= ToDecimal(first_number,16);
		float DecimalSecond= ToDecimal(second_number,16);
		float result= DecimalFirst*DecimalSecond;
		String ResultString=ToHexadecimalNumber(result,16);
		return ResultString;
		}
	public String Divide(String first_number,String second_number)
	{

		/*
		 * method for division of  two hexadecimal numbers
		 * @param decimal_first contains integer part of decimal value
		 * @param decimal_second contains fraction part of decimal value
		 * @param result divided value of decimal numbers
		 * @param result_string contains resulting hexadecimal value in string
		 * @return result_string
		 */
		float DecimalFirst= ToDecimal(first_number,16);
		float DecimalSecond= ToDecimal(second_number,16);
		if(DecimalSecond==0)
		{
			throw new ArithmeticException("divide by 0 exception");
		}
		float result= DecimalFirst/DecimalSecond;
		String ResultString=ToHexadecimalNumber(result,16);
		return ResultString;
	}

	public boolean CheckHexadecimalNumber(String HexNumber)
	{
		/*
		 * method for checking whether given number is in hexadecimal format or not
		 * @param String hex_number
		 * @ result boolean value
		 */
		char[] letters = HexNumber.toCharArray();
		for (char itr: letters)
		{
			if(!((itr>='A' && itr<='F' )||( itr>='0' && itr<='9')|| itr=='.'))
			{
				return false;
			}
		}
		return true;
		
	}
	public boolean Compare(String FirstNumber, String SecondNumber)
	{
		/*
		 * method for comparing two hexadecimal numbers 
		 * default assuming that first string is smaller than second string
		 */
		int flag=1;
		if(FirstNumber.length()<SecondNumber.length())
		{
			return true;
		}
		else if(FirstNumber.length()>SecondNumber.length())
		{
			return false;
		}
		else
		{
			for(int itr=0; itr<SecondNumber.length(); itr++)
			{
				if(FirstNumber.charAt(itr)>SecondNumber.charAt(itr))
				{
					return false;
				}
			}
			return true;
		}
	}
/*	public boolean IsGreater(String FirstNumber, String SecondNumber)
	{
		/*
		 * method for checking whether first number is greater than second number or not
		 * @return true or false
		 */
		/*if(Compare(FirstNumber,SecondNumber)==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean IsSmaller(String FirstNumber, String SecondNumber)
	{
		/*
		 * method for checking whether first number is smaller than second number or not
		 * @return true or false
		 */
	/*	if(Compare(FirstNumber,SecondNumber)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	} */
	public boolean IsEqual(String FirstNumber, String SecondNumber)
	{
		/*
		 * method for checking whether both number are equal or not
		 * @return true or false
		 */
		for(int itr=0; itr<SecondNumber.length(); itr++)
		{
			if(FirstNumber.charAt(itr)!=SecondNumber.charAt(itr))
			{
				return false;
			}
		}
		return true;
	}

}

public class HexCalc {
	public static void main(String args[])
			{
				Scanner input= new Scanner(System.in);
				Hex HexObject=new Hex();
				
				String FirstNumber=null;
				String SecondNumber=null;
				
				while(true)
				{
					System.out.println("***************");
					System.out.println("1.Enter numbers"+"\n"+"2.Add two hexadecimal numbers."
							+"\n"+"3.subtract two hexadecimal numbers."+"\n"
							+"4.Multiply two hexadecimal numbers."+"\n"+
							"5.Divide two hexa decimal numbers."+"\n"
							+"6.First number is greater?"+"\n"+
							"7.First number is Smaller?"+"\n"+"8.Both number are equal?"+"\n"
							+"0 Exit");
					System.out.println("***************");
					System.out.println("Enter your choice");
					int choice;
					try
					{
					choice= input.nextInt();
					switch(choice)
					{
						case 1:	System.out.println("Enter first number");
						FirstNumber=input.next();
								if(HexObject.CheckHexadecimalNumber(FirstNumber))
								{
									System.out.println("Enter second number");
									SecondNumber=input.next();
									if(HexObject.CheckHexadecimalNumber(SecondNumber))
									{
										break;
									}
									else
									{
										System.out.println("enter valid Hexadecimal string");
										break;
									}
								}
								else
								{
									System.out.println("enter valid Hexadecimal string");
									break;
								}
									
						case 2: System.out.println("result: "+HexObject.Add(FirstNumber, SecondNumber));
								break;
						case 3: System.out.println("result: "+HexObject.Subtract(FirstNumber, SecondNumber));
								break;
						case 4: System.out.println("result: "+HexObject.Multiplication(FirstNumber, SecondNumber));
								break;
						case 5: try
								{System.out.println("result: "+HexObject.Divide(FirstNumber, SecondNumber));}
								catch(ArithmeticException e)
								{System.out.println(e.getMessage());}
								break;
						case 6: System.out.println("result: "+HexObject.Compare(FirstNumber,SecondNumber));
								break;
						case 7: System.out.println("result: "+HexObject.Compare(FirstNumber, SecondNumber));
								break;
						case 8: System.out.println("result: "+HexObject.IsEqual(FirstNumber, SecondNumber));
								break;
						case 0: System.out.println("Thank you");
								return;
						default: System.out.println("Please enter valid choice");
								break;
					}
					}
					catch(java.util.InputMismatchException e)
					{
						System.out.println("enter valid choice");
						
					}
				}

			}
}
