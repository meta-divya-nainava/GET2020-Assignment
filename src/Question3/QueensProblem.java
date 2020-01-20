package Question3;

/* @author Divya Nainava
 * @date 20-01-2020
 * The class implements methods to solve the queens problem.
 */
import java.util.*;

public class QueensProblem {

	public static boolean createChessboard(int dimensionOfChess)
			throws Exception {
		/*
		 * method to create chessboard for queens probelm
		 * 
		 * @param dimensionOfChess contains dimension of matrix
		 * 
		 * @param i is iterator
		 * 
		 * @param j is iterator
		 * 
		 * @return boolean value that all queens can be placed or not
		 */
		if (dimensionOfChess <= 3) {
			throw new Exception("dimension of matrix should be greater than 3");
		}
		int[][] chessBoard = new int[dimensionOfChess][dimensionOfChess];
		for (int i = 0; i < dimensionOfChess; i++) {
			for (int j = 0; j < dimensionOfChess; j++) {
				chessBoard[i][j] = 0;
			}
		}
		Boolean result = solveQueen(chessBoard, 0, dimensionOfChess);
		for (int i = 0; i < dimensionOfChess; i++) {
			for (int j = 0; j < dimensionOfChess; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println("\n");
		}
		return result;
	}

	public static Boolean solveQueen(int[][] chessBoard, int column,
			int dimensionOfChess) throws Exception {
		/*
		 * Recursive method to solve the queens problem
		 * 
		 * @param chessBoard is the initial array containing all zeroes.
		 * 
		 * @column is the value of the initial column.
		 * 
		 * @dimensionOfChess is the value of the number of rows/columns in the
		 * matrix.
		 */
		if (column >= dimensionOfChess) {
			return true;
		}
		for (int i = 0; i < dimensionOfChess; i++) {
			if (checkIfQueenCanBePlaced(chessBoard, i, column,
					dimensionOfChess)) {
				chessBoard[i][column] = 1;
				if (solveQueen(chessBoard, column + 1, dimensionOfChess)) {
					return true;
				}
				chessBoard[i][column] = 0;
			}
		}
		return false;

	}

	public static Boolean checkIfQueenCanBePlaced(int[][] chessBoard,
			int row, int column, int dimensionOfChess) {
		/*
		 * Method to check if queen can be placed in the cell.
		 * 
		 * @param chessBoard is the initial array containing all zeroes.
		 * 
		 * @param row is the value of row at which validity is to be checked.
		 * 
		 * @param col is the value of column at which validity is to be checked.
		 * 
		 * @param dimensionOfChess is the value of the number of rows/columns in
		 * the matrix.
		 */

		for (int i = 0; i < column; i++) {
			if (chessBoard[row][i] == 1) {
				return false;
			}
		}
		for (int i = row, j = column; i < dimensionOfChess && j >= 0; i++, j--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Dimensions of Chessboard");
		int dimensionOfChess = input.nextInt();
		QueensProblem object = new QueensProblem();
		System.out.println(object.createChessboard(dimensionOfChess));
	}
}