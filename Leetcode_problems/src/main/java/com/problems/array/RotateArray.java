package com.problems.array;

import java.util.Arrays;

/*

1. Leet Code Code Problem Number: 189

2. Leet Code Code Problem Name: Rotate Array

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Complexties:-

1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)


 */
public class RotateArray 
{
	public static void rotateArray(int nums[],int k)
	{
		int n=nums.length;
		
		// Handle cases where k >= n
		k=k%n;
		
		// Step 1: Reverse the entire array
		reverse(nums,0,n-1);
		
		// Step 2: Reverse the first k elements
		reverse(nums,0,k-1);
		
		// Step 3: Reverse the remaining n - k elements
		reverse(nums,k,n-1);
	}
	
	public static void reverse(int nums[],int start,int end)
	{
		while(start<end)
		{
			// Swap nums[start] and nums[end]
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}	
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,3,4,5,6,7};
		int k=3;
		
		rotateArray(nums,k);
		
	    System.out.println(Arrays.toString(nums));
		
		
		
	}
}
