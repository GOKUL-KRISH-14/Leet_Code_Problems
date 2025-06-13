package com.problems.string;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
 */

public class Length_Last_Word 
{
	public static int lengthLastWord(String s)
	{
		int start=s.length()-1;
		int length=0;
		
		while(start>=0 && s.charAt(start)==' ')
		{
			start--;
		}
		
		while(start>=0 && s.charAt(start)!=' ')
		{
			start--;
		    length++;
		}
		
		return length;
	}
	
	public static void main(String args[])
	{
		String inputString="Gokula Krishnan  ";
		
		int result=lengthLastWord(inputString);
		
		System.out.println("The Length of the Last Word of the String is: "+result);
		
		
		
		
	}

}
