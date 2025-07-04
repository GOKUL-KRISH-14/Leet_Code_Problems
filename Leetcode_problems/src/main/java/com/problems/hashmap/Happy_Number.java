package com.problems.hashmap;

/*

1. Leet code Problem Number :- 202
2. Leet code Problem Name :- Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1.

Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true

Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Complexity :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(1)

 */

public class Happy_Number 
{
	public static boolean happyNumber(int n)
	{
		// Slow pointer moves one step
		int slow=n;
		
		// Fast pointer moves two steps
		int fast=getSumOfSquares(n);
		
		// Loop until fast becomes 1 (happy) or both pointers meet (cycle)
		while(slow!=fast && fast!=1)
		{
			 // Move one step
			slow=getSumOfSquares(n);
			
			// Move two steps
			fast=getSumOfSquares(getSumOfSquares(fast));
		}	
		
		// If fast reaches 1, it's a happy number
		return fast==1;
	}
	
	public static int getSumOfSquares(int num)
	{
		int sum=0;
		
		while(num>0)
		{
			// Extract last digit
			int digit=num%10;
			
			// Add square of digit to sum
			sum+=digit*digit;
			
			// Remove last digit
			num/=10;
		}
		return sum;
	}

	public static void main(String args[])
	{
		int happy_number=19;
		
		boolean result=happyNumber(happy_number);
		
		if(result)
		{
			System.out.println("\n The Given Number is Happy NUmber");
		}
		else
		{
			System.out.println("\n The Given Number is Not an Happy NUmber");	
		}
	}
}
