package com.problems.binarysearch;

/*

1. Leet Code Problem Number :- 74
2. Leet Code Problem Name :- Search 2 Dimensional Matrix

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Complexity :-

1. Time Complexity :- O(Log m*n)
M-> rows
n->cols
2. Space COmplexity :- O(1)

 */


public class Search_In_2D_Matrix 
{
	public static boolean searchMatrix(int matrix[][],int target)
	{
		// Number of rows
		int m=matrix.length;
		
		// Number of columns
		int n=matrix[0].length;
		
		int left=0;
		
		// Treat matrix as a 1D array with indices [0 ... m*n - 1]
		int right=m*n-1;
		
		while(left<=right)
		{
			// Get the middle index of the virtual 1D array
			int mid=(left+right)/2;
			
			// Row index in the matrix
			int row=mid/n;
			
			// Column Index in the matrix
			int col=mid%n;
			
			// Get the actual matrix value at [row][col]
			int middle_ELement=matrix[row][col];
			
			// If found, return true
			if(middle_ELement==target)
			{
				return true;
			}
			
			// If target is greater, discard left half
			else if(middle_ELement<target)
			{
				left=mid+1;
			}
			
			// If target is smaller, discard left half
			else
			{
				right=mid-1;
			}
		}
		// Target not found
		return false;
		
	}
public static void main(String args[])
{
	int[][] matrix = 
		{
		    {1, 3, 5, 7},
		    {10, 11, 16, 20},
		    {23, 30, 34, 70}
		};
	
		int target = 77;
		
		boolean result=searchMatrix(matrix,target);
		
		if(result)
		{
			System.out.println("\nThe Target ELement is Found");
		}
		else
		{
			System.out.println("\nThe Target ELement is Not Found");
		}

}
}
