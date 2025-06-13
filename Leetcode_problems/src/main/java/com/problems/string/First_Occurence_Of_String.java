package com.problems.string;

/*
Leet Code Problem Number :- 28
Leet Code Problem Name :- Find the Index of the First Occurrence in a String
   
      
Given two strings needle and haystack, 
return the index of the first occurrence of needle in haystack, or 
-1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Complexity :-

Time Complexity: O((m - n + 1) * n)
Space Complexity : O(1)

 */

public class First_Occurence_Of_String 
{
	public static int firstOccur(String haystack, String needle)
	{
	    // Length of the main string
		int m=haystack.length();
		
		// Length of the substring to find
		int n=needle.length();
		
		if(n==0)
		{
			return 0;
		}
		
		// Loop through the haystack until (m - n)
		for(int i=0;i<=m-n;i++)
		{
			// Extract a substring of length n and compare it with needle
			if(haystack.substring(i,i+n).equals(needle))
			{
				return i;
			}
		}
		// If needle is not found
		return -1;
	}
	
	public static void main(String args[])
	{
		String haystack="sadbutsad";
		String needle="sad";
		
		int result=firstOccur(haystack,needle);
		
		if(result!=-1)
		{
			System.out.println("The Index value is: "+result);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
}
