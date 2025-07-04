package com.problems.matrix;

import java.util.Arrays;

/*

Leet Code Problem Number :- 73
Leet Code Problem Name :- Set Matrix Zeros

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Complexity :-

1. Time Complexity :- O(m*n)
2. Space Complexity :- O(m+n)

 */

public class Set_Matrix_Zeros 
{
public static void setMatrixZeros(int[][] matrix)
{
	// Number of rows
	int m=matrix.length;
	
	// Number of columns
	int n=matrix[0].length;
	
	// Create boolean arrays to mark which rows and columns should be zeroed
	boolean rows[]=new boolean[m];
	boolean cols[]=new boolean[n];
	
	// First pass - identify all cells with 0
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(matrix[i][j]==0)
			{
				// Mark the entire row
				rows[i]=true;
				
				// Mark the entire column
				cols[j]=true;
			}
		}
	}
	
	// Set entire rows to 0 if marked
	for(int i=0;i<m;i++)
	{
		if(rows[i])
		{
			Arrays.fill(matrix[i], 0);
		}
	}
	
     // Set entire columns to 0 if marked
	for(int j=0;j<n;j++)
	{
		if(cols[j])
		{
			for(int i=0;i<m;i++)
			{
				matrix[i][j]=0;
			}
		}
	}	
}

public static void printMatrix(int matrix[][])
{
	for(int row[]:matrix)
	{
		for(int val:row)
		{
			System.out.print(val+ " ");
		}
		System.out.println();
	}
}

public static void main(String args[])
{
	int matrix[][]= {{0,1,2,0},{3,4,5,2},{1,3,1,5}
	};
	
	setMatrixZeros(matrix);
	
	System.out.println("AFTER ZEROS MATRIX");
	System.out.println();
	printMatrix(matrix);
		
}
}
