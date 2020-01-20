package AssignmentDay4;

class ArrOperation {

	public static int countClump(int[] arr) throws Exception {
		/*
		 * Return the number of clumps in the input array.Clump in an array is a
		 * series of 2 or more adjacent elements of the same value.
		 * 
		 * @param arr array of input element
		 * 
		 * @param size size of array
		 * 
		 * @param count number of clump
		 * 
		 * @param clump number of adjacent element
		 * 
		 * @param itr iterator
		 * 
		 * @throw Exception when arr is empty.
		 * 
		 * @return count count of clumps.
		 */
		int count = 0;
		int clump = 1;
		int size = arr.length;
		if (size == 0) {
			throw new Exception("Array is empty.");
		}
		if (size == 1) {
			return count;
		}
		for (int itr = 0; itr < (size - 1); itr++) {
			if (arr[itr] != arr[itr + 1]) {
				if (clump >= 2) {
					count += 1;
					clump = 1;
				}

			} else {
				clump += 1;
			}
		}
		if (clump >= 2) {
			count += 1;
			clump = 1;
		}
		return count;
	}

	public static int splitArray(int[] arr) throws Exception {
		/*
		 * Return the index if there is a place to split the input array so that
		 * the sum of the numbers on one side is equal to the sum of the numbers
		 * on the other side else return -1.
		 * 
		 * @param arr array of input element
		 * 
		 * @param size size of array
		 * 
		 * @param start starting index of array
		 * 
		 * @param end ending index of array
		 * 
		 * @param sumLeft sum of element of left part of array
		 * 
		 * @param sumRight sum of element of right part of array
		 * 
		 * @param itr iterator
		 * 
		 * @throw Exception when arr is empty.
		 * 
		 * @return index such that sumLeft=sumRight else -1
		 */
		int size = arr.length;
		if (size == 0) {
			throw new Exception("Array is empty.");
		}
		int start = 0;
		int end = size - 1;
		int sumLeft = arr[start];
		int sumRight = arr[end];

		if (size == 1) {
			return -1;
		}
		while ((start + 1) != end) {
			if (sumLeft <= sumRight) {
				start++;
				sumLeft += arr[start];
			} else {
				end--;
				sumRight += arr[end];
			}
		}
		if (sumLeft == sumRight) {
			return start + 1;
		} else {
			return -1;
		}
	}

	public static int[] fixXY(int[] arr, int x, int y) throws Exception {
		/*
		 * Return an array that contains exactly the same numbers as the input
		 * array, but rearranged so that every X is immediately followed by a Y.
		 * Do not move X within array, but every other number may move.
		 * 
		 * @param arr array of input element
		 * 
		 * @param size size of array
		 * 
		 * @param Index temporary index to hold index of y.
		 * 
		 * @param data temporary variable to hold data.
		 * 
		 * @param resultArray contains resulting array
		 * 
		 * @param itr iterator
		 * 
		 * @throw Exception when arr is empty.
		 * 
		 * @throw Exception when there are unequal numbers of X and Y in input
		 * array.
		 * 
		 * @throw Exception when two adjacents X values are there.
		 * 
		 * @throw Exception when X occurs at the last index of array.
		 * 
		 * @return resultArray
		 */
		int size = arr.length;
		int index = -1;
		int data = 0;
		int[] resultArray = new int[size];
		int itr = 0;
		int flag = 0;
		int countX = 0;
		int countY = 0;
		if (size == 0) {
			throw new Exception("Array is empty.");
		}
		if (arr[size - 1] == x) {
			throw new Exception("X is at last position");
		}
		for (int i = 0; i < size; i++) {
			if (arr[i] == x) {
				countX++;
			}
			if (arr[i] == y) {
				countY++;
			}
		}
		if (countX != countY) {
			throw new Exception("x and y are unequal");
		}
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] == x && arr[i + 1] == x) {
				throw new Exception("Two adjacents X values are there");
			}
		}
		if (arr[0] != x && arr[0] != y) {
			resultArray[itr] = arr[itr];
			itr++;
		}

		for (itr = itr; itr < size; itr++) {
			if (arr[itr] == x) {
				resultArray[itr] = x;
				resultArray[(itr + 1)] = y;
				data = arr[itr + 1];
				if (flag == 0 && index != -1) {
					resultArray[index] = data;
					flag = 1;
				} else {
					flag = 0;
				}
				itr++;

			} else if (arr[itr] == y) {
				index = itr;
				if (data != 0) {
					resultArray[index] = data;
					flag = 1;
					data = 0;
				} else {
					flag = 0;
				}
			} else if (arr[itr] != x && arr[itr] != y && arr[itr - 1] != x) {
				resultArray[itr] = arr[itr];
			} else {
				continue;
			}
		}
		return resultArray;
	}

	public static int largestMirrorSection(int[] arr) throws Exception {
		/*
		 * Method to find and return the length of the largest group of
		 * consecutive numbers which are present in the reverse order.
		 * 
		 * @param arr is the input array of numbers.
		 * 
		 * @size size of array
		 * 
		 * @param count count of mirror section element
		 * 
		 * @return sizeOfLargestMirrorSection
		 * 
		 * @throw exception when the array is empty.
		 */
		int Size = arr.length;
		if (Size == 0) {
			throw new Exception("Array is empty.");
		}

		int sizeOfLargestMirrorSection = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1, count = 0; j > i; j--) {
				int startPoint = i, endPoint = j;
				while (startPoint <= j && arr[startPoint] == arr[endPoint]) {

					count++;
					startPoint++;
					endPoint--;

				}
				if (count > 1 && sizeOfLargestMirrorSection < count) {
					sizeOfLargestMirrorSection = count;
				}
			}
		}
		return sizeOfLargestMirrorSection;
	}

	public static void main(String args[]) {

	}

}
