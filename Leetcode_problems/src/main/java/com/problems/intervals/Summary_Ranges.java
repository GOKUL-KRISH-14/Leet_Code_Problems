package com.problems.intervals;

/*

1.Leet Code Problem Number :- 228
2.Leet Code Problem Name :- Summary Ranges

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
That is, each element of nums is covered by exactly one of the ranges, and there is no integer x
such that x is in one of the ranges but not in nums.

Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]

Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Complexties:-

1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)
  
 */
import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges 
{
	private static List<String> summaryRange(int nums[])
	{
		List<String> result=new ArrayList<String>();
		
		if(nums==null ||nums.length==0)
		{
			return result;
		}
		
		// Initialize start and end to first element
		int start=nums[0];
		int end=nums[0];
		
		// Iterate through the rest of the array
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]==end+1)
			{
				// If current number is consecutive, extend the range
				end=nums[i];
			}
			else
			{
				 // If not consecutive, add the current range to result
				addRange(result,start,end);
				// Start new range
				start=nums[i];
				end=nums[i];
			}
		}
		// Add the last range after loop
			addRange(result,start,end);
		
		return result;
	}
	
	private static void addRange(List<String> result,int start,int end)
	{
		if(start==end)
		{
			// Single element
			result.add(String.valueOf(start));
		}
		else
		{
			// Large Format
			result.add(start+ "->" +end);
		}
	}
	public static void main(String args[])
	{
		int nums[]= {0,1,2,4,5,7};
		
		List<String> result=summaryRange(nums);
		
		System.out.println(result);
		
		
	}

}
