package Assignment1;


public final class Matrix {
	private final int[][] matrix;

	public Matrix(int[][] sparse)throws Exception {
		/*
		 * method for initializing matrix
		 * matrix store row ,column,and value[row,column]
		 * @param sparse sparse matrix entered by user.
		 * @param i iterator used for loop
		 * @param j iterator used for loop
		 * 
		 */
		int count = 0;
		if(sparse == null){
			throw(new Exception("NUll Value of matrix"));
		}
		for (int i = 0; i < sparse.length; i++) {
			for (int j = 0; j < sparse[0].length; j++) {
				if (sparse[i][j] != 0) {
					count ++;
					
				}
			}
		}
		
		matrix = new int[count][3];
		count = 0;
		for (int i = 0; i < sparse.length; i++) {
			for (int j = 0; j < sparse[0].length; j++) {
				if (sparse[i][j] != 0) {
					matrix[count][0] = i;//store row value
					matrix[count][1] = j;//store column value
					matrix[count][2] = sparse[i][j];	// store value at[row,column]
					count++;
				}
			}
		}
	}

	private int maxCol() {
		/*
		 * method to calculate max column in user input sparse matrix
		 */
		int colLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][1] > colLength) {
				colLength = matrix[i][1];
			}
		}
		return colLength+1;
	}
	private int maxRow() {
		/*
		 * method to calculate max row in user input sparse matrix
		 */
		return matrix[matrix.length - 1][0] + 1;
	}

	public int[][] transpose() {
		/*
		 * method to create transpose of given matrix
		 * @param maxCol maximum col length
		 * @param maxRow maximum row length
		 * @param transposedMatrix contains transposed matrix of given matrix
		 * @ return transposed matrix
		 */
		int transposedMatrix[][], i, j, k;
		transposedMatrix = new int[maxCol()][maxRow()];
		for (i = 0, k = 0; i < transposedMatrix[0].length; i++)
			for (j = 0; j < transposedMatrix.length; j++) {
				if (matrix[k][0] == i && matrix[k][1] == j) {
					transposedMatrix[j][i] = matrix[k][2];
					k++;
				} else
					transposedMatrix[j][i] = 0;
			}
		return transposedMatrix;
	}

	public boolean symmetric() {
		/*
		 * method to create transpose of given matrix
		 * @param maxCol maximum col length
		 * @param maxRow maximum row length
		 * @param transposedMatrix contains transposed matrix of given matrix
		 * @ return transposed matrix
		 */
		int transposedMatrix[][] = transpose();
		int i, j, k = -1;
		if (transposedMatrix.length != maxRow())
			return false;
		else
			for (i = 0; i < transposedMatrix.length; i++)
				for (j = 0; j < (transposedMatrix[0].length); j++) {
					k++;
					if (i == matrix[k][0] && j == matrix[k][1] && transposedMatrix[i][j] != matrix[k][2])
						return false;
				}
		return true;
	}
	private int[] size()
	{
		/*
		 * method to return size of matrix
		 */
		return new int[]{(maxRow()),maxCol()};
	}

	
	private int getValue(int index[])
	{
		/*
		 * @param index is the position in original matrix whose value has to be found
		 * @returns  the value at given position 
		 */
		for(int i = 0;i < matrix.length; i++ )
			if((matrix[i][0]) == index[0] && (matrix[i][1]) == index[1])
				return	matrix[i][2];
		return 0;
	}
	
	public int[][] addMatrix(Matrix first,Matrix second) throws Exception
	{
		/*
		 * @param first and @param second are the two matrix whose addition has to be done
		 * @returns the addition of the two sparse matrix in 2-D array format
		 */
		int sizeFirst[] = first.size();
		int sizeSecond[] = second.size();
		if(sizeFirst[0] != sizeSecond[0] || sizeFirst[1] != sizeSecond[1])
		{
			throw new Exception("dimensions are different add operation can not be performed");
		}
		int add[][] = new int[sizeFirst[0]][sizeSecond[1]];
		for(int i = 0 ; i < sizeFirst[0] ;i++ )
			for(int j = 0; j < sizeSecond[1]; j++)
			{
				add[i][j] = first.getValue(new int[]{i, j}) + second.getValue(new int[]{i, j});
			}
		return add;
	}

	public int[][] multiplyMatrix(Matrix first, Matrix second) throws Exception
	{
		/**
		 * @param first @param second are the two matrix whose multiplication has to be done
		 * @param sizeFirst and @param sizeSecond are the sizes of both matrices
		 * @returns return the multiplication of the two sparse matrix in 2-D array format
		 */
		int sizeFirst[] = first.size();
		int sizeSecond[] = second.size();
		if(sizeFirst[1] != sizeSecond[0])
		{
			throw new Exception("Multiplication Can not be performed dimensions are not compatible ");
		}
		int multiply[][] = new int[sizeFirst[0]][sizeSecond[1]];
		for(int i = 0  ; i < sizeFirst[0] ;i++ )
		{
			for(int j = 0; j < sizeSecond[1]; j++)
			{
				for(int k = 0; k < sizeFirst[1]; k++)
				{
					multiply[i][j] += first.getValue(new int[]{i, k}) * second.getValue(new int[]{k, j});
				}
			}	
		}
		return multiply;
	}

	
	public static void main(String arg[]) throws Exception
	{
	}

}

