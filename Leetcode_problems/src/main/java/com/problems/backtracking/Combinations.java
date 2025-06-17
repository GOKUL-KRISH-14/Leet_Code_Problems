package com.problems.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 
1. Leet Code Problem Number :- 77
2. Leet Code Problem Name :- Combinations 

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Complexity :-

1. Time Complexity  :- O((n/k).k)
2. Space Complexity :- O(k)+O(n/k).k)


 */
public class Combinations 
{
	public static List<List<Integer>> combine(int n,int k)
	{
	// This will store all the valid combinations
	List<List<Integer>> result=new ArrayList<>();
	
	// Start backtracking from number 1 with an empty path
	backTrack(n,k,1,new ArrayList<>(),result);
	
	// Return the final list of combinations
	return result;
	}

	/*
	 
     * Backtracking helper method
     * n     - upper bound of number range
     * k     - size of each combination
     * start - current number to begin from
     * path  - current combination being built
     * result- final list of all combinations
     
     */
	
	private static void backTrack(int n, int k, int start, List<Integer> path, 
			List<List<Integer>> result) 
	{
		// If the current combination is of length k, add it to result
		if(path.size()==k)
		{
			// Create a new list to avoid reference issues
		    result.add(new ArrayList<>(path));
		    return;
		}
		
		// Loop through numbers from 'start' to 'n'
		for(int i=start;i<=n;i++)
		{
			// Choose the current number by adding to the path
			path.add(i);
			
			// Recurse with the next number (i + 1)
			backTrack(n,k,i+1,path,result);
			
			 // Backtrack: remove the last added number to explore next option
			path.remove(path.size()-1);
		}
		
	}
	public static void main(String[] args) 
	{
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        
        System.out.print("Enter k: ");
        int k = scan.nextInt();

        List<List<Integer>> combinations = combine(n, k);

        System.out.println("Combinations:");
        for (List<Integer> combo : combinations) 
        {
            System.out.println(combo);
        }

    }
}


