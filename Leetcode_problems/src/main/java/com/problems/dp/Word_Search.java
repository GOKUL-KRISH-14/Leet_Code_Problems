package com.problems.dp;

/*
Given a string s and a dictionary of strings wordDict, return true 
if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true

Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Search 
{
	private static boolean word_Search(String s, List<String> wordDict)
	{
	    // Convert wordDict list to a HashSet for fast lookup (O(1) time)
	    Set<String> wordSet = new HashSet<>(wordDict);

	    // dp[i] represents whether substring s[0..i-1] can be segmented using wordDict
	    boolean dp[] = new boolean[s.length() + 1];
	    
	 // Empty string can always be segmented
	    dp[0] = true; 

	    // Iterate through lengths from 1 to s.length()
	    for (int i = 1; i <= s.length(); i++)
	    {
	        // Check all possible partitions ending at position i
	        for (int j = 0; j < i; j++)
	        {
	            // If s[0..j-1] can be segmented (dp[j] == true)
	            // and s[j..i-1] is in wordDict, then s[0..i-1] can also be segmented
	            if (dp[j] && wordSet.contains(s.substring(j, i)))
	            {
	            	// Mark as true since a valid split is found
	                dp[i] = true; 
	                
	             // No need to check further splits for this i
	                break;        
	            }
	        }
	    }

	    // The value at dp[s.length()] tells us if the entire string s can be segmented
	    return dp[s.length()];
	}

	
	public static void main(String args[])
	{
		String s="catsandog";
		List<String> wordDict=new ArrayList<>();
		
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		
		boolean result=word_Search(s,wordDict);
		
		System.out.println(result);
		
	}
}
