package com.problems.slidingwindow;

/*

1. Leet Code Problem Number :- 30
2. Leet Code Problem Name :- Substring with Concatenation of All Words

You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of 
any permutation of words concatenated.

Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]

Explanation:
The substring starting at 0 is "barfoo". 
It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". 
It is the concatenation of ["foo","bar"] which is a permutation of words
 
Complexties :-

1. Time Complexity :- O(n * m)
2. Space Complexity :- O(m * k)
 
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_Concatenation_Of_All_Words 
{
	private static List<Integer> string_Concatenation(String s,String words[])
	{
		List<Integer> result=new ArrayList<Integer>();
		
		 // Edge case checks
		if(s==null ||s.length()==0|| words==null|| words.length==0)
		{
			return result;
		}
		
		// Length of each word (all words are same length)
		int wordLen=words[0].length();
		
		// Total number of words
		int wordCount=words.length;
		
		// Total length of concatenated substring
		int totalLen=wordLen*wordCount;
		
		 // If string length is less than total concatenated length, return empty
		if(s.length()<totalLen)
		{
			return result;
		}
		
		 // Map to store frequency of each word
		Map<String,Integer> wordMap=new HashMap<String,Integer>();
		
		for(String word:words)
		{
			wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
		}
		
		// Try all possible starting points in the first wordLen window
		for(int i=0;i<wordLen;i++)
		{
			// Left pointer of the window
			int left=i;
			
			// Number of valid words matched
			int count=0;
			
			// Map to store words seen in current window
			Map<String,Integer> seen=new HashMap<String,Integer>();
			
			 // Move right pointer in word-length steps
			for(int right=i;right+wordLen<=s.length();right+=wordLen)
			{
				// Current word
				String word=s.substring(right,right+wordLen);
				
				// If word exists in wordMap
				if(wordMap.containsKey(word))
				{
					// Add word to seen map
					seen.put(word, seen.getOrDefault(word, 0)+1);
					count++;
				
				// If seen more than required, shrink from left
				while(seen.get(word)>wordMap.get(word))
				{
					String leftWord=s.substring(left,left+wordLen);
					seen.put(leftWord, seen.get(leftWord)-1);
					count--;
					left+=wordLen;
				}
				
				 // If all words matched exactly, record starting index
				if(count==wordCount)
				{
					result.add(left);
				}
			}
				else
				{
					// If invalid word, reset window
					seen.clear();
					count=0;
					left=right+wordLen;
				}
			}		
		}
	// Return list of valid starting indices
	return result;
	}
	public static void main(String[] args) 
	{
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        List<Integer> result = string_Concatenation(s, words);
        System.out.println("Output indices: " + result);  
    }
}