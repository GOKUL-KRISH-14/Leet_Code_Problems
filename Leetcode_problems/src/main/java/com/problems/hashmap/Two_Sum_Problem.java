package com.problems.hashmap;

import java.util.Arrays;
import java.util.HashMap;

/*

1. Leet code Problem Number :- 1
2. Leet code Problem Name :- Two sum Problem

Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

Complexity :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(n)

 */

public class Two_Sum_Problem 
{
	public static int[] twoSumProblem(int nums[],int target)
	{
		 // Create a HashMap to store number and its index
		HashMap<Integer,Integer> map=new HashMap<>();
		
		int n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			// Find the number needed to reach the target
			int complement=target-nums[i];
			
			// Check if the complement is already in the map
			if(map.containsKey(complement))
			{
				// If found, return the pair of indices
				return new int[] {map.get(complement),i};
			}
			// If not found, store the current number and its index in the map
			map.put(nums[i], i);
		}
		// This line should never be reached as per problem constraints
		return new int[] {-1,-1};
	}
	
	public static void main(String args[])
	{
		// Input array and target value
		int nums[] = {2, 7, 11, 15};
		int target = 9;

		int[] result = twoSumProblem(nums, target);

		// Print the result
		System.out.println("Answer is: " + Arrays.toString(result));
	}
}
