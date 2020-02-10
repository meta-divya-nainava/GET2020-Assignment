package Assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
public class MatrixTest {

	//test for null value as input
	@Test
	public void testMatrixNullArray() {
		 try {
			 new Matrix(null);
		 }
		 catch (Exception e) {
			 assertEquals("NUll Value of matrix", e.getMessage());
		 }
	}


	//Addition operation of two matrix of different size
	@Test
	public void testMatrixAdditionDimension() {
		 try {
			 	Matrix first=new Matrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
				Matrix second=new Matrix(new int[][]{{2, 2, 2, 2}, {2, 2, 2, 2}});
				first.addMatrix(first,second);
		 }
		 catch (Exception e) {
			 assertEquals("dimensions are different add operation can not be performed", e.getMessage());
		 }
	}

	//positive test case for addition operation
	@Test
	   public void testAddMatrix() throws Exception{	
			Matrix first = new Matrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			Matrix second = new Matrix(new int[][]{{2, 2}, {2, 2}, {2, 2}});
			int returnedArrOperation[][] = first.addMatrix(first,second);
		   int [][]expectedArr = new int[][]{{4, 5}, {7, 8}, {8, 11}};
		   Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	//test for multiplication of two matrices with n x m and p x q size
	@Test
	public void testMatrixDimension() {
		 try {
			 	Matrix first = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
				Matrix second = new Matrix(new int[][]{{2, 2, 2, 2},{2, 2, 2, 2}});
				first.multiplyMatrix(first,second);
		 }
		 catch (Exception e) {
			 assertEquals("Multiplication Can not be performed dimensions are not compatible ", e.getMessage());
		 }
	}

	// positive test case for matrix multiplication
	@Test
	   public void testMultiplyMatrix() throws Exception{	
			Matrix first = new Matrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			Matrix second = new Matrix(new int[][]{{2, 2, 2, 2}, {2, 2, 2, 2}});
			int returnedArrOperation[][] = first.multiplyMatrix(first,second);
		    int [][]expectedArr = new int[][]{{10, 10, 10, 10}, {22, 22, 22, 22}, {30, 30, 30, 30}};
		    Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	// test for transpose of matrix
	@Test
	   public void testTransposeMatrix() throws Exception{	
			Matrix first = new Matrix(new int[][]{{2, 3}, {5, 6}, {6, 9}});
			int returnedArrOperation[][] = first.transpose();
		   int [][]expectedArr = new int[][]{{2, 5, 6}, {3, 6, 9}};
		   Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	//positive test case for symmetric matrix
	@Test
	   public void testSymmetricMatrixTrue() throws Exception{	
			Matrix first = new Matrix(new int[][]{{1, 2, 3}, {2, 5, 4}, {3, 4, 9}});
			 assertTrue(first.symmetric() );
	   }

	//negative test case for symmetric matrix where matrix is of n x m size 
	@Test
	   public void testSymmetricMatrixFalse() throws Exception{	
			Matrix first = new Matrix(new int[][]{{2, 3}, {5, 4}, {4, 9}});
			 assertFalse(first.symmetric());
	   }

	// negative test case for symmetric matrix where matrix is of n x n size
	@Test
	   public void testSymmetricMatrixFalse1() throws Exception{	
			Matrix first = new Matrix(new int[][]{{2, 3, 1} ,{5, 4, 6}, {7, 8, 9}});
			 assertFalse(first.symmetric());
	   }
}
