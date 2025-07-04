package com.problems.string;

/*
 Leet Code Problem Number:- 14
 Leet Code Problem Name:- Longest Common Prefix
 
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example:
Input: strs = ["flower", "flow", "flight"]
Output: "fl"

Complexties :-

1. Time Complexity :- O(s)
2. Space Complexity :- O(1)
*/

public class Longest_Common_Prefix 
{
    
    public static String longestCommonPrefix(String strs[])
    {
        
        if(strs == null || strs.length == 0)
        {
            return "";
        }

        // Start by assuming the prefix is the first string
        String prefix = strs[0];

        // Compare prefix with each string in the array
        for(int i = 1; i < strs.length; i++)
        {
            // While the current string doesn't start with the prefix, shrink the prefix
            while(strs[i].indexOf(prefix) != 0)
            {
                // Remove the last character from the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if(prefix.isEmpty())
                {
                    return "";
                }
            }
        }

        // Return the final longest common prefix
        return prefix;
    }

    public static void main(String args[])
    {
        String strs[] = {"flower", "flow", "flight"};

        String result = longestCommonPrefix(strs);

        System.out.println("\nThe Longest Common Prefix of the String is: " + result);
    }
}
