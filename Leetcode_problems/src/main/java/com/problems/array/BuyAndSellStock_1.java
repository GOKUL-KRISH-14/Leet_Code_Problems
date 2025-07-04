package com.problems.array;

/*
1.Leet code Problem Number :- 121

2.Leet code Problem Name :- BuyAndSellStock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock 
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.
 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5

Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Complexties:-
1. Time Complexity  :- O(n)
2. Space Complexity :- O(1)

 */

public class BuyAndSellStock_1 
{

	public static int buyAndSellStock(int prices[])
	{
		if(prices.length==0 || prices==null)
		{
			return 0;
		}
		
		// Track the minimum price so far
		int minPrice=Integer.MAX_VALUE;
		
		// Track the maxmium profit so far
		int maxProfit=0;
		
		int n=prices.length;
	
		for(int i=0;i<n;i++)
		{
			if(prices[i]<minPrice)
			{
				// Update minPrice if a lower price is found
				minPrice=prices[i];
			}
			else 
			{
				// Calculate profit if sold today, and update maxProfit
				maxProfit=Math.max(maxProfit, prices[i]-minPrice);
			}
		}
		return maxProfit;
	}
	
	public static void main(String args[])
	{
	  int prices[]= {7,1,5,3,6,4};
	  
	  int result=buyAndSellStock(prices);
	  
	  System.out.println("\n Buy and Sell Stock of the Problem 1 Result is: "+result);
	}
}

