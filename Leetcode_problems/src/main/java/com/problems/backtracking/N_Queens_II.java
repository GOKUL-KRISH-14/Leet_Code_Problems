package com.problems.backtracking;

/*
 
1. Leet Code Problem Number :- 52
2. Leet Code Problem Name :- N Queens
 
The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Complexity :-

1. Time Complexity  :- O(N!)
2. Space Complexity :- O(N)

 */

public class N_Queens_II 
{
	// To count the number of valid solutions
	static int count=0;
	
	private static int nQueensProblem(int n)
	{
		
		// Create tracking arrays:
		
		// Columns
		boolean cols[]=new boolean[n];
		
		// Main diagonals (row - col + n - 1)
		boolean diag1[]=new boolean[2*n-1];
		
		// Anti-diagonals (row + col)
		boolean diag2[]=new boolean[2*n-1];
		
		// Start backtracking from row 0
		backTrack(0,n,cols,diag1,diag2);
		
		return count;
	}

	// Recursive backtracking function
	private static void backTrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) 
	{
		// If all queens are placed successfully, increment count
		if(row==n)
		{
			count++;
			return;
		}
		
		for(int col=0;col<n;col++)
		{
			// Main diagonal index
			int d1=row-col+n-1;
			
			// Anti diagonal index
			int d2=row+col;
			
			 // Skip if the current column or diagonals are already attacked
			if(cols[col]||diag1[d1]||diag2[d2])
			{
				continue;
			}
			
			// Place the queen
			cols[col]=diag1[d1]=diag2[d2]=true;
			
			// Move to the next row
			backTrack(row+1,n,cols,diag1,diag2);
			
			// Backtrack: remove the queen
			cols[col]=diag1[d1]=diag2[d2]=false;		
	}
}
		public static void main(String[] args) 
		{
	        int n = 4; 
	        int result = nQueensProblem(n);
	        System.out.println("Total distinct solutions for " + n + "-Queens: " + result);
	    }
	}
	
	
	


