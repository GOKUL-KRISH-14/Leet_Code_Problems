package com.problems.twopointers;

import java.util.Arrays;
/*

 1. Leet Code Problem Number :- 167
 2. Leet Code Problem Name :- Two Sum-II Input Array is Sorted

* Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
* find two numbers such that they add up to a specific target number. 
* Let these two numbers be numbers[index1] and numbers[index2] 
  where 1 <= index1 < index2 <= numbers.length.

* Return the indices of the two numbers, index1 and index2, 
* added by one as an integer array [index1, index2] of length 2.

* The tests are generated such that there is exactly one solution. 
* You may not use the same element twice.
* Your solution must use only constant extra space

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Complexity :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(1)

 */
public class Two_Sum_Problem 
{
	public static int[] twoSumProblem(int nums[], int target)
	{
		// Initialize left pointer at the start
		int left=0;
		
		// Initialize left pointer at the End
		int right=nums.length-1;
		
		 // Loop until the two pointers meet
		while(left<right)
		{
			// Calculate the current sum
			int sum=nums[left]+nums[right];
			
			if(sum==target)
			{
				// If sum matches the target, return 1-based indices
				return new int[] {left+1,right+1};
			}
			else if(sum<target)
			{
				// If sum is too small, move left pointer to the right to increase sum
				left++;
			}
			else
			{
				// If sum is too big, move right pointer to the left to decrease sum
				right--;
			}
		}
		// This line will never be reached as input always has one solution
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
