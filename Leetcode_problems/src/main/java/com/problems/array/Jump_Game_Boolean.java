package com.problems.array;

/*

1. Leet Code Code Problem Number: 55
2. Leet Code Code Problem Name: Jump Game
 
You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true

Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Complexties:-
1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)

 */

public class Jump_Game_Boolean 
{
	public static boolean jumpGame(int nums[])
	{	
		int n=nums.length;
		
		if(n==0)
		{
			return false;
		}
		
		// Variable to track the farthest index we can reach
		int maxReach=0;
		
		for(int i=0;i<n;i++)
		{
			// If the current index is beyond maxReach, we cannot proceed further
			if(i>maxReach)
			{
				return false;
			}
			
			// Update the maxReach if the current position allows us to go further
			maxReach=Math.max(maxReach,i+nums[i]);
		}
		
		// If loop completes, it means we can reach the end
		return true;
	}
	
	public static void main(String args[])
	{
		int jump[]= {2,3,1,1,4};
		
		boolean result=jumpGame(jump);
		
		if(result)
		{
			System.out.println("The Jump Game is possible in this array");
		}
		else
		{
			System.out.println("The Jump Game is not possible in this array");	
		}
	}

}
