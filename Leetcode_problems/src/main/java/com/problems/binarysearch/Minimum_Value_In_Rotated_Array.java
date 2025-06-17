package com.problems.binarysearch;

/*

1. Leet Code Problem Number :- 153
2. Leet Code Problem Name :- Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 
1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Complexity :-
1. Time Complexity :- O(Log N)
2. Space COmplexity :- O(1)

 */


public class Minimum_Value_In_Rotated_Array 
{
	public static int min_value_rotated_Array(int nums[])
	{
		int left=0;
		int right=nums.length-1;
		
		// loop until the search space is narrowed down to one element
		while(left<right)
		{
			int mid=(left+right)/2;
			
			 // If middle element is greater than the rightmost element,
            // it means the minimum is in the right half
			if(nums[mid]>nums[right])
			{
				left=mid+1;
			}
			else
			{
				// Else the minimum is in the left half including mid
				right=mid;
			}
		}
		// At the end of loop, left == right and pointing to the minimum element
		return nums[left];
	}
	public static void main(String[] args) 
    {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum in arr1: " + min_value_rotated_Array(arr1));    
    }

}
