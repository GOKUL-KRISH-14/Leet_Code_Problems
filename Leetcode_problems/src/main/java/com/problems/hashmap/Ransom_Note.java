package com.problems.hashmap;

/*
1. Leet Code Problem Number :- 383
2. Leet Code Problem Name :- Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed 
by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "aa", magazine = "aab"
Output: true

Complexity :-

1. Time Complexity: O(m + n)
where m is the length of magazine and n is the length of ransomNote.

2. Space Complexity: O(1)

 */

public class Ransom_Note 
{
	public static boolean canConstruct(String ransomNote,String magazine)
	{
		// Array to store the frequency of each character in the magazine
		int count[]=new int[26];
		
		 // Count characters in the magazine
		for(char c:magazine.toCharArray())
		{
			count[c-'a']++;
		}
		
		// Check if ransomNote can be formed
		for(char c:ransomNote.toCharArray())
		{
			if(--count[c-'a']<0)
			{
				// Not enough characters
				return false;
			}
		}
		// All characters in ransomNote are available
		return true;
	}
	public static void main(String args[])
	{
		String ransomNote="aa";
		String magazine="aab";
		
		boolean result=canConstruct(ransomNote,magazine);
		
        if (result) 
        {
            System.out.println("Ransom note can be constructed from magazine.");
        }
        else 
        {
            System.out.println("Ransom note cannot be constructed from magazine.");
        }
	}
}
