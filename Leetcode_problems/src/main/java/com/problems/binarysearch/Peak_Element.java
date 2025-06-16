package com.problems.binarysearch;

/*

1. Leet Code Problem Number :- 162
2. Leet Code Problem Name :- Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. 
In other words, an element is always considered to be strictly greater than a neighbor that is outside 
the array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2

Explanation: 3 is a peak element and your function should return the index number 2.

Complexity :-

1. Time Complexity :- O(Log N)
2. Space Complexity :- O(1)
 */

public class Peak_Element 
{
	public static int peakElement(int nums[])
	{
		// Initialize the search space with left and right boundaries
		int left=0;
		int right=nums.length-1;
		
		// Continue the binary search until the search space narrows to one element
		while(left<right)
		{
			// Find the middle index
			int mid=(left+right)/2;
			
			 // Compare mid with its right neighbor
			if(mid<nums.length-1 && nums[mid]>nums[mid+1])
			{
				// Peak is on the left half (including mid)
				right=mid;
			}
			else
			{
				 // Peak is on the right half (excluding mid)
				left=mid+1;
			}
		}
		return left;	
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,1,3,5,6,4};
		int result=peakElement(nums);
		
		System.out.println("\n THE PEAK ELEMENT OF THE ARRAY IS: "+result);
	}

}
