package com.problems.array;

/*
Leet code Problem Number :- 27
Leet code Problem Name   :- Remove Element

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]

Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Complexties:-

1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)

 */
public class Remove_Element 
{
	public static int removeELement(int nums[],int val)
	{
		// k keeps track of the index where the next non-val element should go
		int k=0;
		
		// Total number of elements in the array
		int n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			// If current element is not equal to 'val', keep it        
			if(nums[i]!=val)
			{
				// Move non-val element to the correct position and increment k
				nums[k++]=nums[i];
			}
		}
		return k;
	}
	
	public static void main(String args[])
	{
		int[] nums= {1,2,3};
		int value=2;
		
		int result=removeELement(nums,value);
		
		for(int i=0;i<result;i++)
		{
          System.out.println(nums[i]);			
		}
		
	}
}
