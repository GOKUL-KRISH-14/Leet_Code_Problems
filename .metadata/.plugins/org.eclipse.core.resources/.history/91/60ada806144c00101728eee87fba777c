package com.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

 */

public class Generate_Parenthesis 
{
	// Function to generate all valid parentheses combinations
	private static List<String> generate_Parenthesis(int n)
	{
		List<String> result=new ArrayList<>();
		
		// Start the backtracking process
		backTrack(result,"",0,0,n);
		
		return result;
	}

	/*
     * Backtracking helper method
     * result - list to store valid combinations
     * current - current string being built
     * open - number of '(' used so far
     * close - number of ')' used so far
     * max - total number of pairs allowed
     */
	
	private static void backTrack(List<String> result, String current, int open, int close, int max) 
	{
		//if the current string has 2*n characters, it's a valid combination
		if(current.length()==max*2)
		{
			result.add(current);
			return;
		}
		
		// If we can still add an opening parenthesis
		if(open<max)
		{
			backTrack(result,current+"(",open+1,close,max);
		}
		
		// If we can add a closing parenthesis without invalidating the string
		if(close<open)
		{
			backTrack(result,current+")",open,close+1,max);
		}
	}
	
	public static void main(String args[])
	{
		int n=3;
		
		List<String> result=generate_Parenthesis(n);
		
		for(String output:result)
		{
			System.out.println(output);
		}
	}

}
