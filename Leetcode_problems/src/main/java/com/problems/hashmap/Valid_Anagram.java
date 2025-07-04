package com.problems.hashmap;

/*

Leet code Problem Number :- 242
Leet code Problem Name :- Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Complexity :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(1)

 */
public class Valid_Anagram 
{
	public static boolean isValidAnagram(String s,String t)
	{
		// If lengths are different, they can't be anagrams
		if(s.length()!=t.length())
		{
			return false;
		}
		
		// Create a count array to store frequency of each character (26 lowercase letters)
		int count[]=new int[26];
		
		// Loop through both strings at the same time
		for(int i=0;i<s.length();i++)
		{
			// Increment the count for character from string s
			count[s.charAt(i)-'a']++;
			
			// Decrement the count for character from string t
			count[t.charAt(i)-'a']--;
		}
		
		// Check if all counts are zero
        // If not zero, the strings have different character frequencies → not anagrams
		for(int c:count)
		{
			if(c!=0)
			{
				return false;
			}
		}
		// If all counts are zero → strings are anagrams
		return true;
	}
	
	public static void main(String args[])
	{
		String s="ramar";
		String t="armra";
		
		boolean result=isValidAnagram(s,t);
		
		if(result)
		{
			System.out.println("\n THE GIVEN STRING IS ANANGRAM");
		}
		else
		{
			System.out.println("\n THE GIVEN STRING IS NOT ANANGRAM");
		}
	}

}
