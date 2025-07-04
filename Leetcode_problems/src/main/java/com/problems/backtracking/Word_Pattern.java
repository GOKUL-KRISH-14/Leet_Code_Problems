package com.problems.backtracking;

/*

1. Leet Code Problem Number :- 79
2. Leet Code Problem Name :- Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

 */


public class Word_Pattern 
{
	// Main function to check if the word exists in the board
	private static boolean wordPattern(char board[][],String word)
	{
		// number of rows
		int m=board.length;
		
		// number of columns
		int n=board[0].length;
		
		// Traverse each cell in the board
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				 // Start DFS if the first letter matches
				if(board[i][j]==word.charAt(0))
				{
					if(dfs(board,word,i,j,0))
					{
						// word found
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
     * DFS function to search for the word
     * Parameters:
     * - board: the grid
     * - word: the target word
     * - i, j: current position in the board
     * - index: current character index in the word
     */

	private static boolean dfs(char[][] board, String word, int i, int j, int index) 
	{
		// If we've matched all characters, return true
		if(index==word.length())
		{
			return true;
		}
		
		// Boundary check and character mismatch check
		if(i<0 || i>=board.length || j<0 || j>=board[0].length|| board[i][j]!=word.charAt(index))
		{
			return false;
		}
		
		// Store the current character and mark the cell as visited
		char temp=board[i][j];
		board[i][j]='#';
		
		// Explore all 4 directions (up, down, left, right)
		boolean found=dfs(board,word,i+1,j,index+1)||  // down 
				dfs(board,word,i-2,j,index+1)||        // up
				dfs(board,word,i,j+1,index+1)||        // Right
				dfs(board,word,i,j-1,index+1);         // Left
				
		// Restore the original character for backtracking
		board[i][j]=temp;
		return found;
	}
	
	public static void main(String args[])
	{
		char board[][]= {{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
};
		String word="ABCCED";
		
		boolean result=wordPattern(board,word);
		
		if(result)
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(result);
		}
	}
}
