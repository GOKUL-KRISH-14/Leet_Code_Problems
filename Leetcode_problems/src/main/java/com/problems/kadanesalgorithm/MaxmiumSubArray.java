package com.problems.kadanesalgorithm;

/*

1. Leet Code Problem Number :- 53
2. Leet Code Problem Name :- Maxmium Sub Array

Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6

Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Complexity :-

1. Time Complexity :- O(N)
2. SPace Complexity:- O(1)

*/

public class MaxmiumSubArray 
{
	private static int maxSubArray(int nums[])
	{
		// Stores the maximum sum found so far
		int maxSum=nums[0];
		
		// Stores the maximum sum ending at the current position
		int curSum=0;
		
		for(int i=0;i<nums.length;i++)
		{
			// Either extend the current subarray or start a new one from current element
			curSum=Math.max(nums[i], curSum+nums[i]);
			
			// Update the global maximum if needed
			maxSum=Math.max(maxSum, curSum);
		}
		return maxSum;
	}
	public static void main(String args[])
	{
		int nums[]= {-2,1,-3,4,-1,2,1,-5,4};
		int result=maxSubArray(nums);
		
	    System.out.println("\n The Maxmium SubArray of the SUM is: "+result);
	}

}
