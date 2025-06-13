package com.problems.array;

/*

Leet code Problem Number :- 26
Leet code Problem Name   :- Remove Duplicates from Sorted Array

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Complexties:-

1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)
 */

public class Remove_Duplicates_From_Sorted_Array 
{
	public static int sortedArray(int nums[])
	{
		if(nums.length==0)
		{
			return 0;
		}
		
		// Pointer for the next unique position
		int k=1;
		
		int n=nums.length;
		
		// Start from second element and compare with previous
		for(int i=1;i<n;i++)
		{
			if(nums[i]!=nums[i-1])
			{
				// Place unique element at index k
				nums[k]=nums[i];
				k++;
			}
		}
		// Number of unique elementss
		return k;
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,1};
		
		int result=sortedArray(nums);
		
		for(int i=0;i<result;i++)
		{
			System.out.println(nums[i]);
		}
	}

}
