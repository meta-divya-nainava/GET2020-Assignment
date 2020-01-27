/*
 * @author Divya Nainava
 * @date 21-01-2020
 * Implement the immutable class Poly using an array to represent single variable polynomial. Note that you should be storing only those terms of polynomial that have non zero coefficient. You can assume that the coefficients are integers

It should support methods like - 

evaluate(float) - return the value of the polynomial for the given value of the variable

degree() - return the degree of the polynomial

addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1 and p2

multiplyPoly(Poly p1, Poly p2) - return the product of polynomials p1 and p2

You may use private helper methods. addPoly() and multiplyPoly() can make assumptions about size of the resulting polynomial to decide about the size of the array to be created.

 */

package Question2;

import java.util.*;

class PolyObject {
	/*
	 * this class is used to create object that contains coefficient and degree
	 */
	int coefficient;
	int degree;

	public PolyObject(int localCoefficient, int localDegree) {
		coefficient = localCoefficient;
		degree = localDegree;
	}

}

final class polyArray {
	private ArrayList<PolyObject> polyArray = new ArrayList<PolyObject>();

	public ArrayList<PolyObject> getPoly() {
		/*
		 * method to return polyArray
		 */
		return polyArray;
	}

	public void addPoly(PolyObject polyItem) throws Exception {
		/*
		 * method to add element(object) to polyArray
		 * 
		 * @param polyItem object contains coefficient and degree
		 */
		if(polyItem.degree<0)
		{
			throw new Exception("Enter degree greater than 0");
		}
		if (polyItem.coefficient != 0) {
			polyArray.add(polyItem);
		}
	}

	public float evaluate(float value) {
		/*
		 * Method to evaulate polynomial for the given value of the variable
		 * 
		 * @param result contains calculated value
		 * 
		 * @return result
		 */

		float result = 0;
		for (int itr = 0; itr < polyArray.size(); itr++) {
			result += (float) (Math.pow(value, polyArray.get(itr).degree) * polyArray
					.get(itr).coefficient);
			System.out.println(polyArray.get(itr).coefficient + "\t"
					+ polyArray.get(itr).degree);
		}
		return result;
	}

	public int degree() {
		/*
		 * method to return degree of polynomial
		 * 
		 * @param max contains maximum degree
		 * 
		 * @return max
		 */
		int max = 0;
		for (int itr = 0; itr < polyArray.size(); itr++) {
			if (polyArray.get(itr).degree >= max) {
				max = polyArray.get(itr).degree;
			}
		}
		return max;
	}

	public void displayPoly() {
		/*
		 * method to display contains of polyArray
		 */
		for (int itr = 0; itr < polyArray.size(); itr++) {
			System.out.println(polyArray.get(itr).coefficient + "\t"
					+ polyArray.get(itr).degree);
		}
	}

	public ArrayList<PolyObject> add2Poly(ArrayList<PolyObject> poly1,
			ArrayList<PolyObject> poly2) {
		/*
		 * method to add two polynomial
		 * 
		 * @param polyLength1 size of first polynomial
		 * 
		 * @param polyLength2 size of second polynomial
		 * 
		 * @param result contains final polynomial after addition
		 * 
		 * @return result
		 */
		ArrayList<PolyObject> result = new ArrayList<PolyObject>();
		int polyLength1 = poly1.size();
		int polyLength2 = poly2.size();
		int itr1 = 0;
		int itr2 = 0;
		while (itr1 < polyLength1 || itr2 < polyLength2) {
			if (poly1.get(itr1).degree == poly2.get(itr2).degree) {
				int localCoefficient = poly1.get(itr1).coefficient
						+ poly2.get(itr2).coefficient;
				PolyObject object = new PolyObject(localCoefficient,
						poly1.get(itr1).degree);
				result.add(object);
				itr1++;
				itr2++;
			} else if (poly1.get(itr1).degree > poly2.get(itr2).degree) {
				PolyObject object = new PolyObject(poly1.get(itr1).coefficient,
						poly1.get(itr1).degree);
				result.add(object);
				itr1++;
			} else {
				PolyObject object = new PolyObject(poly2.get(itr1).coefficient,
						poly2.get(itr1).degree);
				result.add(object);
				itr2++;
			}
		}
		while (itr1 < polyLength1) {
			PolyObject object = new PolyObject(poly1.get(itr1).coefficient,
					poly1.get(itr1).degree);
			result.add(object);
			itr1++;
		}
		while (itr2 < polyLength2) {
			PolyObject object = new PolyObject(poly2.get(itr1).coefficient,
					poly2.get(itr1).degree);
			result.add(object);
			itr1++;
		}

		return result;

	}

	public ArrayList<PolyObject> multiplyPoly(ArrayList<PolyObject> poly1,
			ArrayList<PolyObject> poly2) {
		/*
		 * method to multiply two polynomial
		 * 
		 * @param polyLength1 size of first polynomial
		 * 
		 * @param polyLength2 size of second polynomial
		 * 
		 * @param result contains final polynomial after multiplication
		 * 
		 * @return result
		 */
		ArrayList<PolyObject> result = new ArrayList<PolyObject>();
		int polyLength1 = poly1.size();
		int polyLength2 = poly2.size();
		int localCoefficient;
		int localDegree;
		for (int itr1 = 0; itr1 < polyLength1; itr1++) {
			System.out.println("poly1=" + poly1.get(itr1).coefficient);
			for (int itr2 = 0; itr2 < polyLength2; itr2++) {
				System.out.println("poly2=" + poly2.get(itr2).coefficient);
				localCoefficient = (poly1.get(itr1).coefficient)
						* (poly2.get(itr2).coefficient);
				System.out.println("l=" + localCoefficient);
				localDegree = (poly1.get(itr1).degree)
						+ (poly2.get(itr2).degree);
				PolyObject object = new PolyObject(localCoefficient, localDegree);
				result.add(object);
			}
		}
		for (int itr = 0; itr < result.size() - 1; itr++) {
			if (result.get(itr).degree == result.get(itr + 1).degree) {
				result.get(itr).coefficient = result.get(itr).coefficient
						+ result.get(itr + 1).coefficient;
				result.remove(itr + 1);
			}
		}

		return result;

	}
}

public class Poly {
	public static void main(String args[]) {
	}

}
