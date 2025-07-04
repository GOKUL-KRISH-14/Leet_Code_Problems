package com.problems.dp;

/*

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you 
from robbing each of them is that adjacent houses have security systems connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4

Explanation: 
Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12

Explanation: 
Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 
 */
public class House_Robbers 
{
	private static int house_Robber(int nums[])
	{
	    // If the input array is null or empty, there is no house to rob
	    if (nums == null || nums.length == 0)
	    {
	        return 0;
	    }

	    // If there is only one house, rob it
	    if (nums.length == 1)
	    {
	        return nums[0];
	    }

	 // Maximum amount if we rob up to the house before previous (i-2)
	    int prev2 = 0; 
	 // Maximum amount if we rob up to previous house (i-1)
	    int prev1 = 0; 

	    // Iterate through each house value in nums
	    for (int num : nums)
	    {
	        // Decide: rob this house (prev2 + num) or skip it (prev1)
	        int temp = Math.max(prev1, prev2 + num);

	     // Update prev2 and prev1 for the next iteration
	     // prev2 moves to prev1
	        prev2 = prev1; 
	        
	     // prev1 becomes current max
	        prev1 = temp;  
	    }

	    // After the loop, prev1 contains the maximum amount we can rob
	    return prev1;
	}

	
	public static void main(String args[])
	{
		int nums[]= {1,2,3,1};
		
		int result=house_Robber(nums);
		
		System.out.println(result);
	
	}

}
