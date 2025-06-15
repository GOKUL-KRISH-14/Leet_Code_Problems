package com.problems.hashmap;

import java.util.HashMap;

/*

1. Leet Code Problem Number :- 290
2. Leet Code Problem Name :- Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter 
in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
 
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Complexity :-

1. Time Complexity: O(n)
2. Space Complexity: O(1)

 */
public class Word_Pattern 
{
	public static boolean wordPattern(String pattern,String s)
	{
		 // Split the string into words using space
		String words[]=s.split(" ");
		
		// If pattern length and number of words are not equal, pattern can't match
		if(pattern.length()!=words.length)
		{
			return false;
		}
		
		// HashMap to map pattern character to word
		HashMap<Character,String> charToWord=new HashMap<Character,String>();
		
		// HashMap to map word to pattern character (reverse mapping)
		HashMap<String,Character> wordToChar=new HashMap<String,Character>();
		
		// Loop through each character and corresponding word
		for(int i=0;i<pattern.length();i++)
		{
			// current character from pattern
			char c=pattern.charAt(i);
			
			// current word from string
			String word=words[i];
			
			// Check if it maps to the same word as before
			if(charToWord.containsKey(c))
			{
				// Check if it maps to the same word as before
				if(!charToWord.get(c).equals(word))
				{
					// Mismatch in mapping → Not a valid pattern
					return false;
				}
			}
			else
			{
				 // If the word is already mapped to some other character
				if(wordToChar.containsKey(word))
				{
					// This violates one-to-one mapping
					return false;
				}
			}
			// Store the mapping from character to word and word to character
			charToWord.put(c,word);
			wordToChar.put(word,c);
		}
		// All mappings are consistent, pattern matches
		return true;
	}
	public static void main(String args[])
	{
		String pattern="abba";
		String s="dog cat cat fish";
		
		boolean result=wordPattern(pattern,s);
		
		if(result)
		{
			System.out.println("\n The Given String Matches the Word Pattern");
		}
		else
		{
			System.out.println("\n The Given String is Not Matches the Word Pattern" );
		}
	}
}
