package com.problems.slidingwindow;

/*
Leet Code Problem Number :- 209
Leet Code Problem Name :- Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than or equal to target. 
If there is no such subarray, return 0 instead.
 
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2

Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Complexity:-
1. Time Complexity  :- O(N)
2. Space Complexity :- O(1)
 */


public class Minimum_Size_Subarray_Sum 
{
	private static int minSubarraySum(int nums[],int target)
	{
		int n=nums.length;
		
		// Left pointer of the sliding window
		int left=0;
		
		// Variable to keep track of the current window sum
		int sum=0;
		
		 // Initialize minLength to maximum value to later find the minimum
		int minLength=Integer.MAX_VALUE;
		
		// Iterate over the array using right pointer
		for(int right=0;right<n;right++)
		{
			// Add current element to the window sum
			sum+=nums[right];
			
			// Shrink the window from the left while sum >= target
			while(sum>=target)
			{
				// Update the minimal length
				minLength=Math.min(minLength, right-left+1);
				
				 // Remove nums[left] from sum and move left pointer
				sum-=nums[left++];
			}
		}
		// If no valid subarray was found, return 0
		return minLength==Integer.MAX_VALUE?0:minLength;
	}
	
	public static void main(String args[])
	{
		int nums[]= {2,3,1,2,4,3};
		int target=7;
		
		int result=minSubarraySum(nums,target);
	}

}
