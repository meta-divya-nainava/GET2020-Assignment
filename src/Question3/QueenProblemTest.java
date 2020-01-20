package Question3;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Assert;

public class QueenProblemTest {

	@Test
	public void QueensProblemTest1(){
	try{
		QueensProblem.createChessboard(1);
		}
	catch (Exception e){
		assertEquals("dimension of matrix should be greater than 3",e.getMessage());
	}
	}
	@Test
	public void QueensProblemTest2(){
	try{
		QueensProblem.createChessboard(0);
		}
	catch (Exception e){
		assertEquals("dimension of matrix should be greater than 3",e.getMessage());
	}
	}
}