// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import static java.lang.Math.*;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		if(grid.length == 0 || grid[0].length == 0) return  0;
		int minVertical = grid.length, maxVertical = 0, minHorizontal = grid[0].length, maxHorizontal = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==ch){
					minVertical = min(minVertical,i);
					maxVertical = max(maxVertical,i);
					minHorizontal = min(minHorizontal,j);
					maxHorizontal = max(maxHorizontal,j);
				}
			}
		}
		System.out.println(minHorizontal+" "+maxHorizontal+" "+minVertical+" "+maxVertical);
		if(maxVertical < minVertical || maxHorizontal < minHorizontal) return 0;
		return (maxVertical-minVertical+1)*(maxHorizontal-minHorizontal+1); // YOUR CODE HERE
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int ret = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(plusOnCoordinates(i,j))
					ret++;
			}
		}
		return ret;
	}

	private boolean plusOnCoordinates(int x, int y){
		int counter = 1;
		while(true){
			if(cellEquals(x-counter,y,grid[x][y]) && cellEquals(x+counter,y,grid[x][y]) && cellEquals(x,y-counter,grid[x][y]) && cellEquals(x,y+counter,grid[x][y]) ){
				counter++;
			}
			else if(cellEquals(x-counter,y,grid[x][y]) || cellEquals(x+counter,y,grid[x][y]) || cellEquals(x,y-counter,grid[x][y]) || cellEquals(x,y+counter,grid[x][y])) return false;
			else break;
		}
		if(counter > 1) return true;
		return false;
	}

	private boolean cellEquals(int x,int y, char c){
		if(x< 0 || x >= grid.length || y< 0 || y >= grid[0].length) return false;
		if(grid[x][y] == c) return true;
		return false;
	}

}
