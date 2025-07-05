package com.problems.dp;

import java.util.Arrays;

public class Coin_Change_Problem
{
	private static int coin_Change(int coins[],int amount)
	{
		// Initialize max value to represent infinity (amount + 1 is large enough)
		int max=amount+1;
		
		// Create dp array to store minimum coins for each amount from 0 to amount
		int dp[]=new int[max];
		
		// Fill dp array with max value initially
		Arrays.fill(dp,max);
		
		// Base case: to make amount 0, we need 0 coins
		dp[0]=0;
		
		// Build up dp array for all amounts from 1 to amount
		for(int i=1;i<=amount;i++)
		{
			// Try every coin
			for(int coin:coins)
			{
				// If coin value is less than or equal to current amount i
				if(coin<=i)
				{
				// Update dp[i]: either keep old value or use current coin
				dp[i]=Math.min(dp[i], dp[i-coin]+1);
			}
		}
		}
		// If dp[amount] was not updated, return -1 (not possible)
		return dp[amount]>amount?-1:dp[amount];
	}
	
	public static void main(String args[])
	{
		int coins[]= {1,2,5};
		int amount=11;
		
		int result=coin_Change(coins,amount);
		
		System.out.println("Coin Change Result: "+result);
		
	}

}
