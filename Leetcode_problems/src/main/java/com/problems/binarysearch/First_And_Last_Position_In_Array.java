package com.problems.binarysearch;

/*
 
1. Leet Code Problem Number :- 34
2. Leet Code Problem Name :-  Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Complexity :-

1. Time Complexity :- O(Log N)
2. Space COmplexity :- O(1)

 */
public class First_And_Last_Position_In_Array 
{
	public static int[] findArray(int nums[],int target)
	{
		// Find the first occurrence
		int first=find_First(nums,target);
		
		// Find the Last occurrence
		int last=find_Last(nums,target);
		
		// Return result as an array
		return new int[] {first,last};
	}

	 // Binary search to find the first occurrence of the target
	private static int find_First(int[] nums, int target)
	{
		int left=0;
		int right=nums.length-1;
		
		// Default if not found
		int index=-1;
		
		while(left<=right)
		{
			int mid=(left+right)/2;
			
			if(nums[mid]==target)
			{
				// Update index and continue searching left
				index=mid;
				right=mid-1;
			}
			else if(nums[mid]<target)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		return index;
	}

	// Binary search to find the Last occurrence of the target
	private static int find_Last(int[] nums, int target) 
	{
		int left=0;
		int right=nums.length-1;
		
		// Default if not found
		int index=-1;
		
		while(left<=right)
		{
	int mid=(left+right)/2;
			
			if(nums[mid]==target)
			{
				// Update index and continue searching right
				index=mid;
				left=mid+1;
			}
			else if(nums[mid]<target)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
		}
	}
		return index;
	}
	public static void main(String[] args)
    {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = findArray(nums, target);

        System.out.println("First and Last Positions of " + target + " are: [" + result[0] + ", " + result[1] + "]");
    }
}

	

