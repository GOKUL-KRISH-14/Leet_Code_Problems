package com.problems.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

 1. Leet Code Problem Number :- 167
 2. Leet Code Problem Name :- Two Sum-II Input Array is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
find two numbers such that they add up to a specific target number. 
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, 
added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. 
You may not use the same element twice.

Your solution must use only constant extra space

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Complexity :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(n)

 */
public class Two_Sum_Problem 
{

	public static int[] twoSumProblem(int nums[], int target)
	{
		// Create a HashMap to store value -> index mapping for quick lookup
		Map<Integer, Integer> map = new HashMap<>();

		// Iterate through the array
		for (int i = 0; i < nums.length; i++)
		{
			// Calculate the complement of the current element
			int complement = target - nums[i];

			// If the complement is already in the map, return the pair of indices
			if (map.containsKey(complement))
			{
				// Return the indices (1-based indexing used here)
				return new int[] { map.get(complement) + 1, i + 1 };
			}

			// If complement not found, add the current element and its index to the map
			map.put(nums[i], i);
		}

		// If no pair found, return an empty array
		return new int[] {};
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
