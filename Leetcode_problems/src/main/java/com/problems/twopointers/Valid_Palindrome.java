package com.problems.twopointers;

/*
 1. Leet Code Problem Number :- 125
 2. Leet Code Problem Name :- Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
and removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

<<<<<<< HEAD
Complexties:-

Time Complexity: O(n)
Space Complexity : O(1)
=======
Complexities :-
1. Time Complexity :- O(n)
2. Space Complexity :- 0(1)

>>>>>>> 40c61bd92b0817934ac3d851c2c9c697106eef16
 */
public class Valid_Palindrome 
{
	public static boolean validPalindrome(String s)
	{
		s=s.toLowerCase();
		
		// Two Pointers
		int left=0;
		int right=s.length()-1;
		
		while(left<right)
		{
		// skip non‑alphanumeric on the left
		while(left<right && !Character.isLetterOrDigit(s.charAt(left)))
		{
			left++;
		}
		 // skip non‑alphanumeric on the right
		while(left<right && !Character.isLetterOrDigit(s.charAt(right)))
		{
			right--;
		}
		
		// compare
		if(s.charAt(left)!=s.charAt(right))
		{
			return false;
		}
		
		// **advance both pointers** when they match
		left++;
		right--;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		String s="Markram";
		
		boolean result=validPalindrome(s);
		
		if(result)
		{
			System.out.println("The Given String Is Palindrome");
		}
		else
		{
			System.out.println("The Given String is not a Palindrome");
		}
	}

}
