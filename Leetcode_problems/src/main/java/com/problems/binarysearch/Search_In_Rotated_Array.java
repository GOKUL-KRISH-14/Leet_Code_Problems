package com.problems.binarysearch;

/*

1. Leet Code Problem Number :- 33
2. Leet Code Problem Name :- Search In Rotated Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot 
index k (1 <= k < nums.length) such that the resulting array is 
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 

For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Complexity :-

Complexity :-

1. Time Complexity :- O(Log N)
2. Space COmplexity :- O(1)

 */

public class Search_In_Rotated_Array 
{
	public static int searchArray(int nums[],int target)
	{
		// Initialize the search window
		int left=0;
		int right=nums.length-1;
		
		 // Perform binary search
		while(left<=right)
		{
			int mid=(left+right)/2;
			
			// If target found at mid
			if(nums[mid]==target)
			{
				return mid;
			}
			
			// Check if the left half is sorted
			if(nums[left]<=nums[mid])
			{
				// Target lies in the sorted left half
				if(nums[left]<=target && target<=nums[mid])
				{
					// Narrow search to left half
					right=mid-1;
				}
				else
				{
			    // Discard left half
				left=mid+1;
				}
			}
			
			 // Else, the right half is sorted
			else
			{
				// Target lies in the sorted right half
				if(nums[mid]<=target && target<=nums[right])
				{
					// Narrow search to right half
					left=mid+1;
				}
				else
				{
				// Discard right half
				right=mid-1;
				}
			}
		}
		return -1;
	}
	    public static void main(String[] args)
	    {
	        int[] nums = {4, 5, 6, 7, 0, 1, 2};
	        int target = 0;

	        int index = searchArray(nums, target);
	        if(index != -1)
	        {
	            System.out.println("Target " + target + " found at index: " + index);
	        }
	        else
	        {
	            System.out.println("Target " + target + " not found in the array.");
	        }
	    }
	}


