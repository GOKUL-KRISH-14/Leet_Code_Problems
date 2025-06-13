package com.problems.array;

import java.util.Arrays;

/*
1.Leet code Problem Number :- 238

2.Leet code Problem Name :- Product of an array except itself


Given an integer array nums, return an array answer such that answer[i] 
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Complexties:-
1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)

 */
public class ProductArray 
{
	public static int[] productArray(int nums[])
	{
		int n=nums.length;
		
		if(n==0)
		{
			return new int[0];
		}
		
		 // Result array to hold the product of all elements except self
		int result[]=new int[n];
		
		 // Step 1: Calculate left products
		// No element to the left of index 0
		result[0]=1;
		
		for(int i=1;i<n;i++)
		{
			result[i]=result[i-1]*nums[i-1];
		}
		
		// Step 2: Multiply with right products
		 // No element to the right of last index
		int right=1;
		
		for(int i=n-1;i>=0;i--)
		{
			// Multiply current with product of elements to the right
			result[i]*=right;
			
			// Update right product
			right*=nums[i];
		}
		
		return result;
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,3,4};
		
		int result[]=productArray(nums);
		
		System.out.println("\n Product Array is: "+Arrays.toString(result));
		
	}

}
