package com.problems.array;

/*
 
1. Leet Code Code Problem Number: 42

2. Leet Code Code Problem Name: Trapping Rain Water
 
 Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Complexties:-

1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)
 */

public class Trapping_Rain_Water
{
	public static int rainWaterTrapping(int height[])
	{
		int left=0;
		int right=height.length-1;
		
		int leftMax=0;
		int rightMax=0;
		int water=0;
		
		 // Two-pointer approach
		while(left<right)
		{
			// Update leftMax or accumulate trapped water
			if(height[left]<height[right])
			{
				if(height[left]>=leftMax)
				{
					leftMax=height[left];
				}
				
				else
				{
					water+=leftMax-height[left];
				}
				// Move left pointer
				left++;
			}
			else
			{
				// Update rightMax or accumulate trapped water
				if(height[right]>=rightMax)
				{
					rightMax=height[right];
				}
				else
				{
					water+=rightMax-height[right];
				}
				// Move left pointer
				right--;
			}
		}
		// return the result
		return water;
	}

	public static void main(String args[])
	{
		int height[]= {0,1,0,2,1,0,1,3,2,1,2,1};
		int result=rainWaterTrapping(height);
		
		System.out.println(result);
	}
}
