package com.problems.matrix;

/*

Leet Code Problem Number :- 36
Leet Code Problem Name :- Valid Suduko

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input:
 
board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]

Output: true

Complexity :-

1. Time Complexity :- O(1)
2. Space Complexity :- O(1)

 */
public class Valid_Suduko
{
    public static boolean isValidSudoku(char board[][])
    {
    	int n=9;
    	
    	// Create 3 boolean arrays for rows, columns, and 3x3 boxes
    	boolean rows[][]=new boolean[n][n];
    	boolean cols[][]=new boolean[n][n];
    	boolean box[][]=new boolean[n][n];
    	
    	
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			char c=board[i][j];
    			
    			// Skip empty cells
    			if(c=='.')
    			{
    				continue;
    			}
    			
    			// Convert char '1'-'9' to 0-8
    			int num=c-'1';
    			
    			// Calculate box index
    			int boxIndex=(i/3)*3+(j/3);
    			
    			// If number already exists in the row, column, or box → invalid
    			if(rows[i][num] || cols[j][num] || box[boxIndex][num] )
    			{
    				return false;
    			}
    			
    			// Mark the number as seen in row, column, and box
    			rows[i][num]=true;
    			cols[j][num]=true;
    			box[boxIndex][num]=true;
    		}
    	}
    	 // Valid Sudoku
    	return true;
    }
    
    public static void main(String args[])
    {
    	char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };
    	
    	boolean result=isValidSudoku(board);
    	
    	if(result)
    	{
    		System.out.println("\n The Given Sudoku Board is Valid");
    	}
    	else
    	{
    		System.out.println("\n The Given Sudoku Board is Valid");	
    	}
    }
    
}
  
