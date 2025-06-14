package com.problems.string;

/*
 
 1. Leet Code Problem Number :- 6
 2. Leet Code Problem Name :- ZigzagConversion
 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

complexity :-

1. Time Complexity :- O(n)
2. Space Complexity :- O(n)

 */
public class Zigzag_Conversion 
{
	public static String zigzagConversion(String s,int numRows)
	{
		if(numRows==1 || s.length()<=numRows)
		{
			return s;
		}
		

        // Initialize an array of StringBuilder, one for each row
		StringBuilder rows[]=new StringBuilder[numRows];
		
		for(int i=0;i<numRows;i++)
		{
			// Prepare each row builder
			rows[i]=new StringBuilder();
		}
		
		// Current row index
		int index=0;
		
		// Direction flag: false = up, true = down
		boolean goingDown=false;
		
		// Iterate over each character in the string
		for(char c:s.toCharArray())
		{
			// Append character to current row
			rows[index].append(c);
			
			// If we reach the top or bottom row, reverse direction
			if(index==0 || index==numRows-1)
			{
				goingDown=!goingDown;
			}
			
			// Move to next row based on direction
			index+=goingDown?1:-1;
		}
		
		StringBuilder result=new StringBuilder();
		
		// Combine all rows into one result
		for(StringBuilder c:rows)
		{
			result.append(c);
		}
		
		return result.toString();
	}
	
	public static void main(String args[])
	{
		String input_string="PAYPALISHIRING";
		int numRows=4;
		
		String result=zigzagConversion(input_string,numRows);
		
		System.out.println("THE ORIGINAL STRING IS  : "+input_string);
		System.out.println("THE CONVERSION STRING IS: "+result);
		
		
	}

}
