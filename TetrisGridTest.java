import junit.framework.TestCase;
import java.util.*;

public class TetrisGridTest extends TestCase {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false},
			{false, true, true}
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	public void testClear2() {
		boolean[][] before =
				{
						{true, true, true}
				};

		boolean[][] after =
				{
						{false, false, false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	public void testClear3() {
		boolean[][] before =
				{
						{false}
				};

		boolean[][] after =
				{
						{false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	public void testClear4() {
		boolean[][] before =
				{
						{false},
						{true},
						{false},
						{true},
						{false}
				};

		boolean[][] after =
				{
						{false},
						{true},
						{false},
						{true},
						{false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	public void testClear5() {
		boolean[][] before =
				{
						{false},
						{false},
						{false},
						{false},
						{false},
						{false},
						{false},
						{false},
						{false},
						{false}
				};

		for(int i=0; i< 1023;i++){
			String bin = Integer.toBinaryString(i);
			for(int j = bin.length()-1;j>=0;j--){
				before[bin.length()-1-j][0] = (bin.charAt(j) == '1');
			}
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();
			assertTrue( Arrays.deepEquals(before, tetris.getGrid()) );
		}

	}
}
