package compound;

import java.util.HashMap;
import java.util.Map;

public class MolorMass {
	private static Map<Character, Integer> atomicMasses = new HashMap<Character, Integer>();
	static {
		atomicMasses.put('C', 12);
		atomicMasses.put('O', 16);
		atomicMasses.put('H', 1);
	}
	/**
	 * method to convert chemical formula to math formula
	 * @param formula
	 * @return math formula
	 * @throws Exception
	 */
	public String generateMathFormula(String formula) throws Exception
	{
		int i=0;
		String mathFormula="";
		if(formula==null)
		{
			throw new Exception("null string");
		}
		while(i<formula.length()-1)
		{
			if(!this.isFormulaValid(formula.charAt(i)))
			{
				throw new Exception("Invalid formula");
			}
			if(atomicMasses.get(formula.charAt(i))!=null)
			{
				if(atomicMasses.get(formula.charAt(i+1))!=null|| formula.charAt(i+1)=='(')
				{
					mathFormula+=atomicMasses.get(formula.charAt(i))+" "+"+"+" ";
				}
				else if(this.isDigit(formula.charAt(i+1)))
				{
				mathFormula+=atomicMasses.get(formula.charAt(i))+" "+"*"+" ";
				}
				else
				{
					mathFormula+=atomicMasses.get(formula.charAt(i))+" ";
				}
			}
			else if(this.isDigit(formula.charAt(i)))
			{
				if(atomicMasses.get(formula.charAt(i+1))!=null || formula.charAt(i+1)=='(')
				{
					mathFormula+=formula.charAt(i) +" "+"+"+" ";
				}
				else
				{
					mathFormula+=formula.charAt(i)+" ";
				}
				
				
			}
			else if(formula.charAt(i)==')')
			{
				if(atomicMasses.get(formula.charAt(i+1))!=null|| formula.charAt(i+1)=='(')
				{
					mathFormula+=atomicMasses.get(formula.charAt(i))+" "+"+"+" ";
				}
				else if(this.isDigit(formula.charAt(i+1)))
				{
					mathFormula+=formula.charAt(i)+" "+"*"+" ";
				}
				else
				{
					mathFormula+=formula.charAt(i)+" ";
				}
				
			}
			else if(formula.charAt(i)=='(')
			{
				mathFormula+=formula.charAt(i)+" ";
			}
			else
			{
				mathFormula+=formula.charAt(i)+" ";
			}
			i++;
			
		
		}
		if(!this.isFormulaValid(formula.charAt(i)))
		{
			System.out.println("invalid string");
			return null;
		}
		else
		{
		mathFormula+=formula.charAt(i);
		}
		return mathFormula;
		
	}
	/**
	 * method to check whether character is a digit or not
	 * @param character
	 * @return true if digit else false
	 */
	private boolean isDigit(char character)
	{
		if(character=='0'||character=='1'||character=='2'||character=='3'||character=='4'||character=='5'||character=='6'||character=='7'||character=='8'||character=='9')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * method to check whether formula is valid or not
	 * @param char character
	 * @return true if valid else false
	 */
	public boolean isFormulaValid(char character)
	{
		if((character=='('|| character==')'|| this.isDigit(character)|| atomicMasses.get(character)!=null))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	/**
	 * method to compute total molor mass of formula
	 * @param formula
	 * @return computed mass
	 * @throws Exception
	 */
	public int computeMass(String formula) throws Exception
	{
		ExpressionEvaluation expressionEvaulation=new ExpressionEvaluation();
		return expressionEvaulation.evaluateExpression(this.generateMathFormula(formula));
	}
}
