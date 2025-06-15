package com.problems.matrix;

import java.util.ArrayList;
import java.util.List;

/*

Leet Code Problem Number :- 54
Leet Code Problem Name :- Sprial Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Complexity:-

Time Complexity :- O(m x n)
Space Complexity :- O(m x n)

 */

public class Sprial_Matrix 
{
	public static List<Integer> sprialMatrix(int[][] matrix)
	{
		List<Integer> result=new ArrayList<Integer>();
		
		// number of rows
		int m=matrix.length;
		
		// number of columns
		int n=matrix[0].length;
		

	    // Initialize the boundaries of the matrix
		
		// Topmost row index
		int top=0;
		
		// Bottom most row index
		int bottom=m-1;
		
		// Leftmost column index
		int left=0;
		
		// Rightmost column index
		int right=n-1;
		
		// Loop until the boundaries cross
		while(left<=right && top<=bottom)
		{
			// Traverse from left to right on the top row
			for(int i=left;i<=right;i++)
			{
				result.add(matrix[top][i]);
			}
			
			// Move the top boundary down
			top++;
			
			// Traverse from top to bottom on the right column
			for(int i=top;i<=bottom;i++)
			{
				result.add(matrix[i][right]);
			}
			
			// Move the right boundary left
			right--;
			
			// Traverse from right to left on the bottom row (if rows remain)
			if(top<=bottom)
			{
				// Traverse right to left
				for(int i=right;i>=left;i--)
				{
					result.add(matrix[bottom][i]);
				}
				// Move the bottom boundary up
				bottom--;
			}
			
			// Traverse from bottom to top on the left column (if columns remain)
			if(left<=right)
			{
				// Traverse bottom to top
				for(int i=bottom;i>=top;i--)
				{
					result.add(matrix[i][left]);
				}
				// Move the left boundary right
				left++;
			}
		}
		// Return the result list containing spiral order
		return result;
	}
	public static void main(String args[])
	{
		int matrix[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		List<Integer> result=sprialMatrix(matrix);
		
		System.out.println(result);
	}
}
