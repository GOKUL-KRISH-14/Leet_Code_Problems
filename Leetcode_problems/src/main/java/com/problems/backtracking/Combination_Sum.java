package com.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*

1. Leet Code Problem Number :- 39
2. Leet Code Problem Name :- Combination sum

Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations 
that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */

public class Combination_Sum 
{
private static List<List<Integer>> combination_Sum(int candidate[],int target)
{
	// To store all valid combinations
	List<List<Integer>> result=new ArrayList<>();
	
	// Start backtracking
	backTrack(candidate,target,new ArrayList<>(),0,result);
	
	// Return the final result list
	return result;
}

//Recursive backtracking method to find valid combinations
private static void backTrack(int[] candidate, int target, ArrayList path, int start, List<List<Integer>> result) 
{
	// if target becomes 0, a valid combination is found
	if(target==0)
	{
		// Add a deep copy of the current combination
		result.add(new ArrayList<>(path));
		return;
	}
	
	// If target becomes negative, this path is invalid
	if(target<0)
	{
		return;
	}
	
	// Try each candidate starting from current index 'start'
	for(int i=start;i<candidate.length;i++)
	{
		// Choose candidate[i]
		path.add(candidate[i]);
		
		// Recurse with updated target
		backTrack(candidate,target-candidate[i],path,i,result);
		
		// Backtrack: remove last added element
		path.remove(path.size()-1);
	}
}
public static void main(String[] args) 
{
    int[] candidates = {2, 3, 6, 7};
    int target = 7;

    List<List<Integer>> combinations = combination_Sum(candidates, target);

    System.out.println("All combinations that sum to " + target + ":");
    for (List<Integer> combination : combinations) 
    {
        System.out.println(combination);
    }
}
}
