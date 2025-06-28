package com.problems.slidingwindow;

/*

1. Leet Code Problem Number :- 3
2. Leet Code Problem Name :- Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3

Explanation: The answer is "abc", with the length of 3.

Complexties :-

1. Time Complexity :- O(N)
2. Space Complexity :- O(min(n,m))

 */

import java.util.HashSet;
import java.util.Set;

public class Longest_SubString_Without_Repeating
{
	public static int longestString(String s)
	{
		// Length of the input string
		int n=s.length();
		
		// Left pointer of the sliding window
		int left=0;
		
		// Stores the maximum length found so far
		int maxLength=0;
		
		// HashSet to store characters in current window
		Set<Character> window=new HashSet<Character>();
		
		 // Iterate over each character using the right pointer
		for(int right=0;right<n;right++)
		{
			// Current character to be added to window
			char current_char=s.charAt(right);
			
			// If current character is already in the window, move the left pointer
			while(window.contains(current_char))
			{
				// Remove character at left pointer
				window.remove(s.charAt(left));
				
				// Move left pointer to the right
				left++;
			}
			// Add current character to the window
			window.add(current_char);
			
			// Update maximum length if current window is larger
			maxLength=Math.max(maxLength, right-left+1);
		}
		// Return maximum length 
		return maxLength;
	}
	
	public static void main(String args[])
	{
		String s="pwwkew";
		
		System.out.println("\n Longest SubString Character Length is: "+longestString(s));
	}

}
