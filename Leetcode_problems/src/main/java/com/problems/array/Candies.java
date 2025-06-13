package com.problems.array;

import java.util.Arrays;

/*
 
1.Leet code Problem Number :- 135

2.Leet code Problem Name :- Candies Problem
 
There are n children standing in a line. 
Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation:
 You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */


public class Candies 
{
public static int candiesProblem(int ratings[])
{
	int n=ratings.length;
	
	int candies[]=new int[n];
	
	// Step 1: Initialize all candies to 1 (every child must get at least one)
	Arrays.fill(candies, 1);
	
	
	// Step 2: Left to right pass
    // If the current child has a higher rating than the previous one,
    // give one more candy than the previous child.
	for(int i=1;i<ratings.length;i++)
	{
		if(ratings[i]>ratings[i-1])
		{
			candies[i]=candies[i-1]+1;
		}
	}
	
    // Step 3: Right to left pass
    // If the current child has a higher rating than the next one,
    // give max of current candy or (next child's candy + 1)
	for(int i=n-2;i>=0;i--)
	{
		if(ratings[i]>ratings[i+1])
		{
			candies[i]=Math.max(candies[i], candies[i+1]+1);
		}
	}
	
	int totalCandies=0;
	// Step 4: Sum up all candies to get the total minimum required.
	for(int candy:candies)
	{
	   totalCandies+=candy;
	}
	
	return totalCandies;	
}
public static void main(String[] args) 
{
    int[] ratings = {1, 0, 2}; 
    int result = candiesProblem(ratings);
    System.out.println("Minimum candies needed: " + result);
}
}
