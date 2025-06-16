package com.problems.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Leet code Problem Number :- 49
Leet code Problem Name :- Group Anagram

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.


Complexity :-
1. Time Complexity:- total: O(n * k)
n = number of strings
k = max length of a string

2. Space Complexity:

count[26] array: O(1) (fixed size)
map: O(n * k) in the worst case, storing all strings

 */


public class Group_Anagrams 
{
	public static List<List<String>> groupAnagram(String strs[])
	{
		// If input is null or empty, return empty result
		if(strs==null || strs.length==0)
		{
			return new ArrayList<>();
		}
		
		// HashMap to store grouped anagrams with a unique key
		Map<String,List<String>> map=new HashMap<>();
		
		// Traverse each string in the array
		for(String str:strs)
		{
			// Count frequency of each character (a to z)
			int count[]=new int[26];
			
			// Count the frequency of each character in current string
			for(char c:str.toCharArray())
			{
				count[c-'a']++;
			}
			
			// Build a unique key using character frequencies
			StringBuilder sb=new StringBuilder();
			
			for(int i:count)
			{
				// delimiter to avoid collision
				sb.append("#");
				sb.append(i);
			}
			
			// Final key from frequency count
			String key=sb.toString();
			
			map.computeIfAbsent(key, k->new ArrayList<>()).add(str);
		}
		
		// Return all the grouped anagrams
		return new ArrayList<>(map.values());
	}
	
	public static void main(String args[])
	{
		String[] str= {"eat","tea","tan","ate","nat","bat"};
		
		List<List<String>> result=groupAnagram(str);
		
		System.out.println("\n Original String :- "+Arrays.toString(str));
		
		System.out.println("\n Group Anagarm :- "+ result);
	}

}
