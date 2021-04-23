
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}

	public void testCharArea3() {
		char[][] grid = new char[][] {};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('a'));
		assertEquals(0, cg.charArea('b'));
		assertEquals(0, cg.charArea('c'));
	}

	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'c'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('a'));
		assertEquals(1, cg.charArea('c'));
	}

	public void testCharArea5() {
		char[][] grid = new char[][] {
				{'a', ' ', 'a', ' ', 'a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(5, cg.charArea('a'));
		assertEquals(3, cg.charArea(' '));
	}

	public void  testCountPlus1(){
		char[][] grid = new char[][] {
				{'b', 'a', 'c'},
				{'a', 'a', 'a'},
				{'c', 'a', 'b'}
			};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1,cg.countPlus());
	}

	public void  testCountPlus2(){
		char[][] grid = new char[][] {
				{'b', 'a', 'c', 'c'},
				{'a', 'a', 'a', 'a'},
				{'c', 'a', 'b', 'b'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0,cg.countPlus());
	}

	public void  testCountPlus3(){
		char[][] grid = new char[][] {
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{'a', 'a', 'p', 'a', 'y', 'y', 'y', 'c', ' '},
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2,cg.countPlus());
	}

	public void  testCountPlus4(){
		char[][] grid = new char[][] {
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0,cg.countPlus());
	}
}
