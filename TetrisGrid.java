//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid=grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		boolean[][] newGrid = new boolean[grid.length][grid[0].length];
		for(int y=0; y<grid[0].length; y++)
			for(int x=0; x<grid.length; x++)
				newGrid[x][y] = false;

		int curLine = 0;
		for(int y=0; y<grid[0].length; y++){
			if(!lineFull(y)) {
				for (int x = 0; x < grid.length; x++) {
					newGrid[x][curLine] = grid[x][y];
				}
				curLine++;
			}
		}

		grid = newGrid;
	}

	private boolean lineFull(int y){
		for(int x=0;x<grid.length;x++){
			if(grid[x][y]== false) return false;
		}
		return true;
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
