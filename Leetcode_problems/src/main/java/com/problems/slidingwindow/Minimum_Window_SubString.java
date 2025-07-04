package com.problems.slidingwindow;

/*
1. Leet Code Problem Number :- 76
2. Leet Code Problem Name :- Minimum Window Substring

Given two strings s and t of lengths m and n respectively, 
return the minimum window substring of s such that every character 
in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Complexity:-

1. Time Complexity  :- O(S+T)
2. Space Complexity :- O(T)

 */

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_SubString 
{
	private static String minimum_Substring(String s,String t)
	{
		// Edge case check
		if(s==null || t==null || s.length()<t.length())
		{
			return "";
		}
		
		// Left boundary of window
		int left=0;
		
		// Length of smallest valid window found so far
		int minLen=Integer.MAX_VALUE;
		
		// Starting index of the minimum window substring
		int start_Idx=0;
		
		// Map to store required character frequencies from string t
		Map<Character,Integer> targetFreq=new HashMap<>();
		
		for(char c:t.toCharArray())
		{
			targetFreq.put(c,targetFreq.getOrDefault(c, 0)+1);
		}
		
		// Number of unique characters currently matched to desired count
		int formed=0;
		
		// Number of unique characters to match in window
		int required=targetFreq.size();
		
		// Map to store current window character frequencies
		Map<Character,Integer> window=new HashMap<>();
		
		// Iterate with right pointer to expand window
		for(int right=0;right<s.length();right++)
		{
			char c=s.charAt(right);
			
			// Add current character to window map
			window.put(c, window.getOrDefault(c, 0)+1);
			
			// If current character's count matches the required count, increment formed
			if(targetFreq.containsKey(c)&& window.get(c).intValue()==targetFreq.get(c).intValue())
			{
				formed++;
			}
			
			// Try to contract the window from left side as long as all required chars are matched
			while(left<=right && formed==required)
			{
				// Update minimum window size if this window is smaller
				if(right-left+1<minLen)
				{
					minLen=right-left+1;
					start_Idx=left;
				}
				
				char remove_Char=s.charAt(left);
				
				// Remove leftmost character from window map
				window.put(remove_Char, window.get(remove_Char)-1);
				
				// If after removing, a required character's count falls below target, decrement formed
				if(targetFreq.containsKey(remove_Char) && window.get(remove_Char).intValue()
						<targetFreq.get(remove_Char).intValue())
				{
					formed--;
				}
				// Move left pointer to right
				left++;
			}	
		}
		// If no valid window found, return empty string
		return minLen==Integer.MAX_VALUE?"":s.substring(start_Idx,start_Idx+minLen);
	}
	public static void main(String[] args) 
	{
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minimum_Substring(s, t)); // Output: BANC
    }

}
