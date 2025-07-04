package com.problems.array;

import java.util.HashSet;
import java.util.Set;

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
2. Space Complexity :- O(K)

 */
public class Contains_Duplicate_II 
{
	public static boolean containsDuplicate(int nums[],int k)
	{
		// Create a HashSet to store unique elements within a sliding window of size k
		Set<Integer> set=new HashSet<Integer>();
		
		// Traverse the entire array
		for(int i=0;i<nums.length;i++)
		{
			// If the current number is already in the set, a duplicate within range k exists
			if(set.contains(nums[i]))
			{
				return true;
			}
			
			// Add the current number to the set
			set.add(nums[i]);
			
			// If the size of the set exceeds k, remove the oldest number (i - k)
	        // This maintains a sliding window of size at most k
			if(set.size()>k)
			{
				set.remove(nums[i-k]);
			}
		}
		// If no duplicates found within the given range, return false
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
