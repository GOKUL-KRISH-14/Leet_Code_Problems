package com.problems.hashmap;

import java.util.HashMap;
import java.util.Map;

/*

1. Leet code Problem Number :- 219
2. Leet code Problem Name   :- Contains Duplicate II

Given an integer array nums and an integer k, return true 
if there are two distinct indices i and j in the 
array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Explaination :-

Index	Value	Seen Before?	Distance From Previous? 	Valid?
0	     1	       ❌ No					-	-
1	     2	       ❌ No					-	-
2	     3	       ❌ No					-	-
3	     1	       Yes(at index 0)	    3 - 0 = 3	    Yes, because 3 ≤ k

The Duplicate value must be <= K 

Complexity :-

1. Time Complexity :-  O(n)
2. Space Complexity :- O(n)

 */
public class Contains_Duplicate_II 
{
	public static boolean containsDuplicate(int nums[],int k)
	{
		// HashMap to store the number and its latest index
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++)
		{
			// If the number exists and the index difference is <= k
			if(map.containsKey(nums[i]) && (i-map.get(nums[i])<=k))
			{
				// Duplicate found within distance k
				return true;
			}
			
			// Update the latest index of the current number
			map.put(nums[i], i);
		}
		// No valid duplicate found
		return false;
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,3,1};
		int k=3;
		
		boolean result=containsDuplicate(nums,k);
		
		if(result)
		{
			System.out.println("It found");
		}
		else
		{
			System.out.println("Not found");	
		}
	}

}
