package com.problems.string;

/*

Leet code Problem Number :- 151
Leet code Problem Name :- Reverse the words in a string

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. 
Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Complexties :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(1)

 */

public class Reverse_Words_in_String
{
	public static String reverseString(String s)
	{
		// Remove leading and trailing spaces
		s=s.trim();
		
		// Split the string by one or more spaces (\\s+ handles multiple spaces)
		String words[]=s.split("\\s+");
		
		// StringBuilder to build the final reversed string
		StringBuilder res=new StringBuilder();
		
		// Traverse the words array from end to star
		for(int i=words.length-1;i>=0;i--)
		{
		res.append(words[i]);
		
		// Add a space if it's not the last word
		if(i>0)
		{
			res.append(" ");
		}
		}
		// Return the reversed string
		return res.toString();
	}
	
	public static void main(String args[])
	{
		String s="the sky is blue";
		
		String result=reverseString(s);
		
		System.out.println("\n THE ORIGINAL STRING IS: "+s);
		
		System.out.println("\n THE REVERSED STRING IS: "+result);
	}

}
