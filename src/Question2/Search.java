package Question2;
/* @author Divya Nainava
 * @date 20-01-2020
 */

public class Search {
	static int iterator;

	public  static int linearSearch(int[] userInputArray, int elementToBeSearched)
			throws Exception{
		/*
		 * Method to find the index of the element entered as input by the user.
		 * 
		 * @param arr is the array of elements in which the given element will
		 * be searched.
		 * 
		 * @param elementToBeSearched is the element whose index will be
		 * returned to the user.
		 * 
		 * @return index of the element if found in the array else -1 will be
		 * returned.
		 * 
		 * @throw exception if length of array is zero.
		 */
		if (userInputArray.length == 0) {
			throw new Exception("Array is empty.");
		}
		if (userInputArray[iterator] == elementToBeSearched) {
			return iterator+1;
		} else if (iterator != (userInputArray.length - 1)) {
			iterator++;
			return linearSearch(userInputArray, elementToBeSearched);
		} else {
			return -1;
		}
	}

	public static int binarySearch(int[] userInputArray, int elementToBeSearched)
			throws Exception {
		/*
		 * Method to find the index of the element entered as input by the user.
		 * 
		 * @param arr is the array of elements in which the given element will
		 * be searched.
		 * 
		 * @param elementToBeSearched is the element whose index will be
		 * returned to the user.
		 * 
		 * @return index of the element if found in the array else -1 will be
		 * returned.
		 * 
		 * @throw exception if length of array is zero.
		 */
		if (userInputArray.length == 0) {
			throw new Exception("Array is empty.");
		}
		int startIndex = 0;
		int endIndex =userInputArray.length - 1;
		return binarySearch(userInputArray, elementToBeSearched, startIndex,
				endIndex);
	}

	public static  int binarySearch(int[] userInputArray, int elementToBeSearched,
			int lowIndex, int highIndex) {

		  int midIndex = 0;
		  if (highIndex >= lowIndex) {
		  midIndex = lowIndex + (highIndex - lowIndex) / 2;
		  if (userInputArray[midIndex] == elementToBeSearched) {
		  return midIndex;
		  } else if (userInputArray[midIndex] > elementToBeSearched) {
		  return binarySearch(userInputArray, elementToBeSearched, lowIndex, midIndex - 1);
		  } else {
		  return binarySearch(userInputArray, elementToBeSearched, midIndex + 1, highIndex);
		  }
		  }
		  return -1;

		  }

	public static void main(String args[]) {
		
	}

}
