package com.problems.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 1. Leet Code Problem Number :- 15
 2. Leet Code Problem Name :- Three Sum Problem

Given an integer array nums, return all the triplets 
[nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Complexity :-

1. Time Complexity :- O(n*n) N Squared
2. Space Complexity :- O(1)

 */
public class Three_Sum_Problem 
{
	public static List<List<Integer>> threeSumProblem(int nums[])
	{
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++)
		{
			if(i>0 && nums[i]==nums[i-1])
			{
				continue;
			}
			
			int left=i+1;
			int right=nums.length-1;
			
			while(left<right)
			{
				int sum=nums[i]+nums[left]+nums[right];
				
				if(sum==0)
				{
					result.add(Arrays.asList(nums[i],nums[left],nums[right]));
					
					while(left<right && nums[left]==nums[left+1])
					{
						left++;
					}
					
					while(left<right && nums[right]==nums[right-1])
					{
						right--;
					}
				}
				else if(sum<0)
				{
					left++;
				}
				else
				{
					right--;
				}
				left++;
				right--;
			}
		}
		return result;
	}
	public static void main(String args[])
	{
		int nums[]= {-1,0,1,2,-1,-4};
		
		List<List<Integer>> result=threeSumProblem(nums);
		
		System.out.println(result);
		
	}

}
