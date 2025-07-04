package com.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*

1. Leet Code Problem Number :- 46
2. Leet Code Problem Name :- Combinations

Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Complexity :-

1. Time Complexity :- O(nxn!)
2. Space Complexity :- O(N)

 */

public class Permutations 
{
	private static List<List<Integer>> permutations(int nums[])
	{
		// This list will store all the permutations
		List<List<Integer>> result=new ArrayList<>();
		
		// Start the backtracking with an empty temporary list
		backTrack(result,new ArrayList<>(),nums);
		
		return result;
	}

	// Recursive backtracking function
	private static void backTrack(List<List<Integer>> result, ArrayList tempList, int[] nums) 
	{
		// If the current permutation has all elements, add it to the result
		if(tempList.size()==nums.length)
		{
			// Add a deep copy of tempList
			result.add(new ArrayList<>(tempList));
			return;
		}
		else
		{
			// Try each unused element in the array
			for(int i=0;i<nums.length;i++)
			{
				// Skip the element if it's already used in the current permutation
				if(tempList.contains(nums[i]))
				{
					continue;
				}
				// Choose the element
				tempList.add(nums[i]);
				
				// Explore further with the chosen element
				backTrack(result,tempList,nums);
				
				// Backtrack: Remove the last added element to try the next possibility
				tempList.remove(tempList.size()-1);
			}
		}
	}
	public static void main(String[] args) 
	{
        int[] nums = {1, 2, 3}; 
        
        List<List<Integer>> allPermutations = permutations(nums);

        for (List<Integer> perm : allPermutations) 
        {
            System.out.println(perm);
        }
    }
}
