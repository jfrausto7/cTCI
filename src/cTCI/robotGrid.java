package cTCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//custom class for int pairs and arrays
class IntPair {
	  // Ideally, name the class after whatever you're actually using 
	  // the int pairs *for.*
	  final int x;
	  final int y;
	  IntPair(int x, int y) {this.x=x;this.y=y;}
	  // depending on your use case, equals? hashCode?  More methods?
	  
	  public void print() {
		  System.out.print('(');
		  System.out.print(x);
		  System.out.print(", ");
		  System.out.print(y);
		  System.out.print(")");
		  System.out.println("");
	  }
	}

public class robotGrid {
	
	public static ArrayList<IntPair> robotGrid(int row, int col, boolean[][] grid) {
		//base cases
		if(row == 0 && col == 0) return null;
		if(grid == null) return null;

		//make arraylist for path
		ArrayList<IntPair> path = new ArrayList<IntPair>();
		path.add(new IntPair(row-1,col-1)); // destination
		path = moveRobot(row-1, col-1, path, grid);
		//check for no path
		if(path == null) {
			System.out.println("No path!");
			return null;
		}
		return path;
	}
	
	/* helper method to recurse backwards and find path */
	public static ArrayList<IntPair> moveRobot(int r, int c, ArrayList<IntPair> path, boolean[][] grid){
		//print path so far
//		System.out.println("New path: ");
//		for(Object pair : path) {
//			((IntPair) pair).print();
//		}
		
		
		//break recursion cases
		if(r == 0 && c == 0) return path;
		if(r == 0) {
			if(grid[r][c-1] == false) {
				return null;
			}
		}
		else if(c == 0) {
			if(grid[r-1][c] == false) {
				return null;
			}
		}
		else if(grid[r-1][c] == false && grid[r][c-1] == false) return null;
		
		//otherwise recurse backwards first left side
		if(r != 0) {
		if(grid[r-1][c] != false) {
			ArrayList<IntPair> left = (ArrayList<IntPair>) path.clone();
			left.add(new IntPair(r-1,c));
			left = moveRobot(r-1,c,left,grid);
			if(left != null) {
				return left;
			}
		}
		}
			//now up
		if(c != 0) {
		if(grid[r][c-1] != false) {
			ArrayList<IntPair> up = (ArrayList<IntPair>) path.clone();
			up.add(new IntPair(r,c-1));
			up = moveRobot(r,c-1,up,grid);
			if(up != null) {
				return up;
			}
		}
		}
		
		//no path if this code is reached
		return null;
	}
	
	//driver code
	public static void main(String[] args) {
		
		//make grid first
		boolean[][] grid = {
				{true, false, true, false, true},
				{true, true, false, true, false},
				{true, true, false, true, false},
				{false, true, true, true, true},
				{false, true, true, false, true},
				{false, true, true, false, true},
		};
		
		ArrayList<IntPair> result = robotGrid(6,5,grid);
		if(result != null) {
		Object[] path = result.toArray();
		Collections.reverse(Arrays.asList(path));	//reverse array
		
		//print out path
		for(Object pair : path) {
			((IntPair) pair).print();
		}
		}
	}

}
