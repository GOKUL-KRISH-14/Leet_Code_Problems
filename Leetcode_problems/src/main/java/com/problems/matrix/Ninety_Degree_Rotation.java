package com.problems.matrix;

/*
 
1. Matrix 90 Degree Rotation
 
Original Matrix:
1 2 3 
4 5 6 
7 8 9 

Matrix after 90-degree Clockwise Rotation:
7 4 1 
8 5 2 
9 6 3 

Complexity :-
Time Complexity: O(n²)
Space Complexity: O(1) 
  
 */

public class Ninety_Degree_Rotation 
{
	public static void rotateMatrix(int matrix[][])
	{
		int n=matrix.length;
		
		//Transpose the matrix (swap matrix[i][j] with matrix[j][i])
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				 // Swap elements across the diagonal
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		//Reverse each row to get the rotated matrix
		for(int i=0;i<n;i++)
		{
			reverseRow(matrix[i]);
		}
	}
	
    // Helper function to reverse a single row
	public static void reverseRow(int row[])
	{
		int left=0;
		int right=row.length-1;
		
		while(left<right)
		{
			int temp=row[left];
			row[left]=row[right];
			row[right]=temp;
			left++;
			right--;
		}
	}
	
	// Function to print the matrix
	public static void printMatrix(int matrix[][])
	{
		for(int row[]:matrix)
		{
			for(int val:row)
			{
				System.out.print(val);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotateMatrix(matrix);

        System.out.println("Matrix after 90-degree Clockwise Rotation:");
        printMatrix(matrix);
    }
}
	
	

