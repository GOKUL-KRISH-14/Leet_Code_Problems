package com.problems.array;

public class Missing_Number 
{
	private static int missingNumber(int nums[],int n)
	{
		int expectedSum=n*(n+1)/2;
		
		int actualSum=0;
		
		for(int num:nums)
		{
			actualSum+=num;
		}
		
		return expectedSum-actualSum;
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,3,5,6};
		int n=6;
		
		int result=missingNumber(nums,n);
		
		System.out.println("\n MISSING NUMBER IN THE ARRAY IS: "+result);
	}

}
