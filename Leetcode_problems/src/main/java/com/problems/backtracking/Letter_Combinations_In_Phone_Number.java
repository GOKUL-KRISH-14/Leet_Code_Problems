package com.problems.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1. Leet Code Problem Number :- 17
2. Leet Code Problem Name :- Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Complexity :-

1. Time Complexity :- O(n)
N-> Number of digits input string

2. Space Complexity :- O(n)

 */


public class Letter_Combinations_In_Phone_Number 
{
public static List<String> letterCombinations(String digits)
{
	List<String> result=new ArrayList<>();
    
	// Edge case: if input is empty, return empty list
	if(digits==null || digits.length()==0)
	{
		return result;
	}
	
	 // Mapping digits 0-9 to corresponding letters (index = digit)
    // '0' and '1' do not map to any letters
	String mappings[]= {
			"",      //0
			"",      //1
			"abc",   //2
			"def",   //3
			"ghi",   //4
			"jkl",   //5
			"mno",   //6
			"pqrs",  //7
			"tuv",   //8
			"wxyz"   //9
			};
	
	// Start backtracking with index 0 and empty path
	backTrack(result,digits,mappings,0,new StringBuilder());
	
	return result;
}

//Helper function for recursive backtracking
private static void backTrack(List<String> result, String digits, String[] mappings, int index,
		                                                                     StringBuilder path) 
{
	// Base case: when current combination length equals digits length
	if(index==digits.length())
	{
		// Add combination to result
		result.add(path.toString());
		return;
	}
	
	// Get possible characters for current digit
	String possible_Characters=mappings[digits.charAt(index)-'0'];
	
	// Iterate through each character and recurse
	for(char ch:possible_Characters.toCharArray())
	{
		// Choose
		path.append(ch);
		
		// Explore
		backTrack(result,digits,mappings,index+1,path);
		
		// Un-choose (backtrack)
		path.deleteCharAt(path.length()-1);
}
}
public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter digits (2-9): ");
    String digits = scan.nextLine();

    List<String> combinations = letterCombinations(digits);

    System.out.println("Possible Letter Combinations:");
    for (String combo : combinations)
    {
        System.out.println(combo);
    }  
}
}

