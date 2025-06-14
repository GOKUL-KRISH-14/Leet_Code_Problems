package com.problems.twopointers;

/*

 1. Leet Code Problem Number :- 11
 2. Leet Code Problem Name :- Container With Most Water

You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and 
(i, height[i]).

Find two lines that together with the x-axis form a container, 
such that the container contains the most water.

Return the maximum amount of water a container can store.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

Explanation: 
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

Complexity :-

Time Complexity: O(n)
Space Complexity: O(1)


 */
public class Container_With_Most_Water 
{
public static int mostWater(int height[])
{
	// Start pointer
	int left=0;
	
	// End pointer
	int right=height.length-1;
	int maxArea=0;
	
	while(left<right)
	{
		// Find the shorter height to calculate area
		int minHeight=Math.min(height[left], height[right]);
		int width=right-left;
		
		// Update maxArea if current area is greater
		maxArea=Math.max(maxArea, minHeight*width);
		
		// Move the pointer of the shorter line inward
		if(height[left]<height[right])
		{
			left++;
		}
		else
		{
			right--;
		}
	}
	return maxArea;
}

public static void main(String args[])
{
	int height[]= {1,8,6,2,5,4,8,3,7};
	
	int result=mostWater(height);
	
	System.out.println("\n THE CONTAINER WITH MOST WATER ANSWER IS: "+result);
}

}
