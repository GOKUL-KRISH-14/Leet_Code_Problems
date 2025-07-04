package com.problems.binarysearch;

/*
1. Leet Code Problem Number :- 352
2. Leet Code Problem Name :- Search Insert Position

Given a sorted array of distinct integers and a target value, 
return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Summary :-

1. If found, return the index.
2. If not found, return the index where it would be inserted (held in left pointer).
3. This maintains O(log n) time and sorted order.

Complexity :-

1. Time Complexity :- O(Log N)
2. Space COmplexity :- O(1)

 */

public class Search_Insert_Position 
{
	public static int search_Insert_Position(int nums[],int target)
	{
		 // Start of the search range
		int left=0;
		
		 // End of the search range
		int right=nums.length-1;
		
		 // Continue searching while range is valid
		while(left<=right)
		{
			// Find the middle index
			int mid=(left+right)/2;
			
			// If target found at mid, return its index
			if(nums[mid]==target)
			{
				return mid;
			}
			
			 // If target is greater, search in the right half
			else if(nums[mid]<target)
			{
				left=mid+1;
			}
			
			// If target is smaller, search in the left half
			else
			{
				right=mid-1;
			}
		}
		
		// If target is not found, return the position where it should be inserted
		return left;
	}
	public static void main(String args[])
	{
		int nums[]= {1,3,5,6};
		int target=9;
		
		int result=search_Insert_Position(nums,target);
		
		System.out.println("\n The Search Index Value of the Given Sorted Array is: "+result);
	}

}
