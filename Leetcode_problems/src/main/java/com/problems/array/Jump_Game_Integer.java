package com.problems.array;

/*

Leet code Problem Number :- 45

Leet code Problem Name :- Jump Game II

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2

Explanation: The minimum number of jumps to reach the last index is 2. 
Jump 1 step from index 0 to 1, then 3 steps to the last index.

Complexties:-
1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)

 */
public class Jump_Game_Integer 
{
	public static int jumpGame(int jump[])
	{
		int n=jump.length;
		
		if(n<=1)
		{
			return 0;
		}

		// Count of jumps
		int jumps=0;
		
		// End of current jump range
		int currentEnd=0;
		
		// Farthest index reachable
		int farthest=0;
		
		for(int i=0;i<jump.length-1;i++)
		{
			// Update the farthest reachable index from current position
			farthest=Math.max(farthest, i+jump[i]);
			
			// If we have reached the end of the current jump range
			if(i==currentEnd)
			{
				// Take a jump
				jumps++;
				
				// Update the range for next jump
				currentEnd=farthest;
			}
		}
		
		// If loop completes, it means we can reach the end
		return jumps;
	}
	
	public static void main(String args[])
	{
		int jumps[]= {2,3,1,1,4};
		
		int result=jumpGame(jumps);
		
		System.out.println("The Minimum Steps to reach the end of an array: "+result);	
	}

}
