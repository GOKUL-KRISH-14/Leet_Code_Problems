package com.problems.hashmap;

/*

1. Leet Code Problem Number :- 205
2. Leet Code Problem Name :- Ransom Note

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the 
order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "foo", t = "bar"
Output: false

Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Complexity :-

1. Time Complexity: O(n)
2. Space Complexity: O(1)
 */

public class Isomorphic_String 
{
	public static boolean isomorphic_String(String s,String t)
	{
		// If the lengths are different, they cannot be isomorphic
	   if(s.length()!=t.length())
	   {
		   return false;
	   }
	   
	   // Arrays to store mapping of characters based on ASCII values (0-255
	   int ch1[]=new int[256];
	   int ch2[]=new int[256];
	   
	   // Traverse through each character in the stringss
	   for(int i=0;i<s.length();i++)
	   {
		  // character from first string
		   char c1=s.charAt(i);
		   
		   // character from second string
		   char c2=t.charAt(i);
		   
		   // If the last seen positions don't match, strings are not isomorphic
		   if(ch1[c1]!=ch2[c2])
		   {
			   return false;
		   }
		   
		   // Store the position (+1 to differentiate from default 0)
		   ch1[c1]=i+1;
		   ch2[c2]=i+1;
	   }
	   // All characters matched successfully with consistent mapping
	   return true;
	}
public static void main(String args[])
{
	String s="foo";
	String t="bar";
	
	boolean result=isomorphic_String(s,t);
	
	if(result)
	{
		System.out.println("\n The Given String is Isomorphic");
	}
	else
	{
		System.out.println("\n The Given String is Not Isomorphic");
	}
}
}
