package Question1;

public class Math {
	public static int HCF(int firstNumber, int secondNumber) throws Exception
	{
		/* Method to find the HCF of two non zero numbers by using recursion.
		* @param firstNumber is the first input given by the user.
		* @param secondNumber is the second input given by the user.
		* @return the HCF of the numbers.
		* @throw exception if both of the two inputs are "0" because their HCF is not defined.
		*/
		if (firstNumber == 0){
		return secondNumber;
		}
		if (secondNumber == 0) {
		return firstNumber;
		}
		if ((firstNumber == 0) && (secondNumber == 0) || firstNumber<0 || secondNumber<0) {
		throw new Exception("Input should be a positive number.");
		}
		if(secondNumber==0)
		{return firstNumber;}
		else
		{
			return HCF(secondNumber,firstNumber%secondNumber);
		}
	}
	public static int LCM(int firstNumber,int secondNumber ) throws Exception
	{
		/* Method to find the LCM of two non zero numbers by using recursion.
		* @param firstNumber is the first input given by the user.
		* @param secondNumber is the second input given by the user.
		* @return the LCM of the numbers.
		* @throw exception if any of the two inputs are "0".
		*/

		if ((firstNumber<=0)||(secondNumber<=0)){
		throw new Exception ("Input should be a positive number");
		}
		int hcf=HCF(firstNumber,secondNumber);
		int lcm=(firstNumber*secondNumber)/hcf;
		return lcm;
	}
	public static void  main(String args[])
	{
	}

}