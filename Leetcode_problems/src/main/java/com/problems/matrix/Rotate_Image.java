package com.problems.matrix;


/*
 
Leet Code Problem Number :- 48
Leet Code Problem Name :- Rotate Image
 
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Complexity :-
Time Complexity: O(n²)
Space Complexity: O(1) 

 */


public class Rotate_Image 
{
	public static void rotateImage(int matrix[][])
	{
		int n=matrix.length;
		
		if(matrix==null || n==0)
		{
			return;
		}

		// Transpose the Matrix
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		// Reverse the Each row
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][n-j-1];
				matrix[i][n-j-1]=temp;
			}
		}
	}
		
		public static void printMatrix(int matrix[][])
		{
			for(int row[]:matrix)
			{
				for(int val:row)
				{
					System.out.print(" "+val+ " ");
				}
				System.out.println("\n");
			}
		}
	
	
	public static void main(String[] args) 
	{
        int[][] matrix = 
        {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        
        //[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotateImage(matrix);

        System.out.println("Matrix After Rotate Image");
        printMatrix(matrix);
}
}
