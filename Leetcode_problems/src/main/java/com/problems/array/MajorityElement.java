package com.problems.array;

/*

1. Leet Code Code Problem Number: 169

2. Leet Code Code Problem Name: Majority_Element
 
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array. 

Example 1:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Complexties:-

1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)

 */

public class MajorityElement
{
	public static int majorityElement(int nums[])
	{
		// Counter for tracking majority
		int count=0;
		
		// Variable to store the current candidate for majority
        int candidate = 0;      
		
		for(int num:nums)
		{
			// If count drops to 0, update candidate to current element
			if(count==0)
			{
				candidate=num;
			}
			
			// If current element equals candidate, increment count
            // Otherwise, decrement count
			count+=(num==candidate)?1:-1;
		}
		
		// Return the element which is the majority candidate
		return candidate;
	}
	
	public static void main(String args[])
	{
		int nums[]= {2,2,1,1,1,2,2};
		
		int result=majorityElement(nums);
		
		System.out.println("\n THE MAJORITY ELEMETS IS: "+result);
	}

}
